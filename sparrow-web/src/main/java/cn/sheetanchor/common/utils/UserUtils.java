package cn.sheetanchor.common.utils;

import cn.sheetanchor.common.security.SystemAuthorizingRealm.Principal;
import cn.sheetanchor.sparrow.sys.dao.*;
import cn.sheetanchor.sparrow.sys.model.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Date 2017/2/6 13:47
 * @Desc 用户工具类
 */
@Component
public class UserUtils {

	@Resource
	private UserDao userDao;
	@Resource
	private RoleDao roleDao;
	@Resource
	private MenuDao menuDao;
	@Resource
	private AreaDao areaDao;
	@Resource
	private OfficeDao officeDao;

	private static UserDao staticUserDao;
	private static RoleDao staticRoleDao;
	private static MenuDao staticMenuDao;
	private static AreaDao staticAreaDao;
	private static OfficeDao staticOfficeDao;
	@PostConstruct
	public void init(){
		//静态方法中注入bean
		UserUtils.staticUserDao = userDao;
		UserUtils.staticRoleDao = roleDao;
		UserUtils.staticMenuDao = menuDao;
		UserUtils.staticAreaDao = areaDao;
		UserUtils.staticOfficeDao = officeDao;

	}

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
	
	public static final String CACHE_AUTH_INFO = "authInfo";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static SysUser get(String id){
		SysUser user = (SysUser)CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (user ==  null){
			user = staticUserDao.findById(id);
			if (user == null){
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		return user;
	}
	
	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static SysUser getByLoginName(String loginName){
		SysUser user = (SysUser)CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
		if (user == null){
			user = staticUserDao.findByLoginName(loginName);
			if (user == null){
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName(), user);
		}
		return user;
	}
	
	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(){
		removeCache(CACHE_AUTH_INFO);
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		UserUtils.clearCache(getUser());
	}
	
	/**
	 * 清除指定用户缓存
	 * @param user
	 */
	public static void clearCache(SysUser user){
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getLoginName());
		if (user.getOffice() != null && user.getOffice().getId() != null){
			CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + user.getOffice().getId());
		}
	}
	
	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static SysUser getUser(){
		Principal principal = getPrincipal();
		if (principal!=null){
			SysUser user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new SysUser();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new SysUser();
	}

	/**
	 * 获取当前用户角色列表
	 * @return
	 */
	public static List<SysRole> getRoleList(){
		@SuppressWarnings("unchecked")
		List<SysRole> roleList = (List<SysRole>)getCache(CACHE_ROLE_LIST);
		if (roleList == null){
			SysUser user = getUser();
			if (user.isAdmin()){
				roleList = staticRoleDao.findAllList();
			}else{
				roleList = user.getRoles();
			}
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}
	
	/**
	 * 获取当前用户授权菜单
	 * @return
	 */
	public static List<SysMenu> getMenuList(){
		@SuppressWarnings("unchecked")
		List<SysMenu> menuList = (List<SysMenu>)getCache(CACHE_MENU_LIST);
		if (menuList == null){
			SysUser user = getUser();
			if (user.isAdmin()){
				menuList = staticMenuDao.findAllList();
			}else{
				menuList = user.getMenuList();
			}
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}
	
	/**
	 * 获取当前用户授权的区域
	 * @return
	 */
	public static List<SysArea> getAreaList(){
		@SuppressWarnings("unchecked")
		List<SysArea> areaList = (List<SysArea>)getCache(CACHE_AREA_LIST);
		if (areaList == null){
			areaList = staticAreaDao.findAllList();
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}
	
	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<SysOffice> getOfficeList(){
		@SuppressWarnings("unchecked")
		List<SysOffice> officeList = (List<SysOffice>)getCache(CACHE_OFFICE_LIST);
		if (officeList == null){
			SysUser user = getUser();
			if (user.isAdmin()){
				officeList = staticOfficeDao.findAllList();
			}else{
				SysOffice office = user.getOffice();
				officeList.add(office);
			}
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}

	/**
	 * 获取当前用户有权限访问的部门
	 * @return
	 */
	public static List<SysOffice> getOfficeAllList(){
		@SuppressWarnings("unchecked")
		List<SysOffice> officeList = (List<SysOffice>)getCache(CACHE_OFFICE_ALL_LIST);
		if (officeList == null){
			officeList = staticOfficeDao.findAllList();
		}
		return officeList;
	}
	
	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	// ============== User Cache ==============
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}


}
