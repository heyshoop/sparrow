package cn.sheetanchor.common.utils;

import cn.sheetanchor.common.config.Global;
import cn.sheetanchor.sparrow.sys.dao.*;
import cn.sheetanchor.sparrow.sys.model.SysLog;
import cn.sheetanchor.sparrow.sys.model.SysMenu;
import cn.sheetanchor.sparrow.sys.model.SysUser;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @Author 阁楼麻雀
 * @Date 2017/2/4 16:47
 * @Desc 日志工具类
 */
@Component
public class LogUtils {
	
	public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";
	@Resource
	private MenuDao menuDao;
	@Resource
	private LogDao logDao;

	private static MenuDao staticMenuDao;
	private static LogDao staticLogDao;
	@PostConstruct
	public void init(){
		//静态方法中注入bean
		LogUtils.staticMenuDao = menuDao;
		LogUtils.staticLogDao = logDao;

	}
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title){
		saveLog(request, null, null, title);
	}
	
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title){
		SysUser user = UserUtils.getUser();
		if (user != null && user.getId() != null){
			SysLog log = new SysLog();
			log.setTitle(title);
			log.setType(ex == null ? SysLog.TYPE_ACCESS : SysLog.TYPE_EXCEPTION);
			log.setRemoteAddr(StringUtils.getRemoteAddr(request));
			log.setUserAgent(request.getHeader("user-agent"));
			log.setRequestUri(request.getRequestURI());
			log.setParams(request.getParameterMap());
			log.setMethod(request.getMethod());
			// 异步保存日志
			new SaveLogThread(log, handler, ex).start();
		}
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread{
		
		private SysLog log;
		private Object handler;
		private Exception ex;

		public SaveLogThread(SysLog log, Object handler, Exception ex){
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}
		@Override
		public void run() {
			// 为当前线程绑定一个session对象,让dao中使用 getCurrentSession的方法可以获取到对应的session
			WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
			SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
			boolean participate = bindHibernateSessionToThread(sessionFactory);
			// 获取日志标题
			if (StringUtils.isBlank(log.getTitle())){
				String permission = "";
				if (handler instanceof HandlerMethod){
					Method m = ((HandlerMethod)handler).getMethod();
					RequiresPermissions rp = m.getAnnotation(RequiresPermissions.class);
					permission = (rp != null ? StringUtils.join(rp.value(), ",") : "");
				}
				log.setTitle(getMenuNamePath(log.getRequestUri(), permission));
			}
			// 如果有异常，设置异常信息
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 如果无标题并无异常日志，则不保存信息
			if (StringUtils.isBlank(log.getTitle()) && StringUtils.isBlank(log.getException())){
				return;
			}
			// 保存日志信息
			log.preInsert();
			try {
				staticLogDao.save(log);
			} finally {
				closeHibernateSessionFromThread(participate, sessionFactory);
			}
		}
		public static boolean bindHibernateSessionToThread(SessionFactory sessionFactory) {
			if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
				return true;
			} else {
				Session session = sessionFactory.openSession();
				session.setFlushMode(FlushMode.MANUAL);
				SessionHolder sessionHolder = new SessionHolder(session);
				TransactionSynchronizationManager.bindResource(sessionFactory, sessionHolder);
			}
			return false;
		}
		public static void closeHibernateSessionFromThread(boolean participate, Object sessionFactory) {

			if (!participate) {
				SessionHolder sessionHolder = (SessionHolder)TransactionSynchronizationManager.unbindResource(sessionFactory);
				SessionFactoryUtils.closeSession(sessionHolder.getSession());
			}
		}
	}

	/**
	 * 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
	 */
	public static String getMenuNamePath(String requestUri, String permission){
		String href = StringUtils.substringAfter(requestUri, Global.getAdminPath());
		Map<String, String> menuMap = (Map<String, String>)CacheUtils.get(CACHE_MENU_NAME_PATH_MAP);
		if (menuMap == null){
			menuMap = Maps.newHashMap();
			List<SysMenu> menuList = staticMenuDao.findAllList();
			for (SysMenu menu : menuList){
				// 获取菜单名称路径（如：系统设置-机构用户-用户管理-编辑）
				String namePath = "";
				if (menu.getParentIds() != null){
					List<String> namePathList = Lists.newArrayList();
					for (String id : StringUtils.split(menu.getParentIds(), ",")){
						if (SysMenu.getRootId().equals(id)){
							continue; // 过滤跟节点
						}
						for (SysMenu m : menuList){
							if (m.getId().equals(id)){
								namePathList.add(m.getName());
								break;
							}
						}
					}
					namePathList.add(menu.getName());
					namePath = StringUtils.join(namePathList, "-");
				}
				// 设置菜单名称路径
				if (StringUtils.isNotBlank(menu.getHref())){
					menuMap.put(menu.getHref(), namePath);
				}else if (StringUtils.isNotBlank(menu.getPermission())){
					for (String p : StringUtils.split(menu.getPermission())){
						menuMap.put(p, namePath);
					}
				}
				
			}
			CacheUtils.put(CACHE_MENU_NAME_PATH_MAP, menuMap);
		}
		String menuNamePath = menuMap.get(href);
		if (menuNamePath == null){
			for (String p : StringUtils.split(permission)){
				menuNamePath = menuMap.get(p);
				if (StringUtils.isNotBlank(menuNamePath)){
					break;
				}
			}
			if (menuNamePath == null){
				return "";
			}
		}
		return menuNamePath;
	}
}
