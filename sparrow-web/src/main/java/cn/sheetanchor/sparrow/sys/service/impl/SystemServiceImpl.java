package cn.sheetanchor.sparrow.sys.service.impl;

import cn.sheetanchor.common.config.Global;
import cn.sheetanchor.common.persistence.Page;
import cn.sheetanchor.common.security.SystemAuthorizingRealm;
import cn.sheetanchor.common.security.shiro.session.SessionDAO;
import cn.sheetanchor.common.service.BaseService;
import cn.sheetanchor.common.utils.*;
import cn.sheetanchor.sparrow.sys.dao.*;
import cn.sheetanchor.sparrow.sys.model.SysRole;
import cn.sheetanchor.sparrow.sys.model.SysUser;
import cn.sheetanchor.sparrow.sys.service.SystemService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/7
 * @Desc
 */
@Service
@Transactional(readOnly = true)
public class SystemServiceImpl extends BaseService implements SystemService,InitializingBean {


    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private SessionDAO sessionDao;
    @Autowired
    private SystemAuthorizingRealm systemRealm;

    public SessionDAO getSessionDao() {
        return sessionDao;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //TODO 同步activiti数据
    }
    /**
     * 根据登录名获取用户
     * @param loginName
     * @return SysUser
     */
    public SysUser getUserByLoginName(String loginName) {
        return UserUtils.getByLoginName(loginName);
    }

    @Transactional(readOnly = false)
    public void updateUserLoginInfo(SysUser user) {
        // 保存上次登录信息
        user.setOldLoginIp(user.getLoginIp());
        user.setOldLoginDate(user.getLoginDate());
        // 更新本次登录信息
        user.setLoginIp(StringUtils.getRemoteAddr(Servlets.getRequest()));
        user.setLoginDate(new Date());
        userDao.updateLoginInfo(user);
    }

    public SysUser getUser(String id) {
        return UserUtils.get(id);
    }

    @Transactional(readOnly = false)
    public void updateUserInfo(SysUser user) {
        user.preUpdate();
        userDao.updateUserInfo(user);
        // 清除用户缓存
        UserUtils.clearCache(user);
    }

    public boolean validatePassword(String oldPassword, String password) {
        String plain = Encodes.unescapeHtml(oldPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0,16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
    }

    @Transactional(readOnly = false)
    public void updatePasswordById(String id, String loginName, String newPassword) {
        SysUser user = new SysUser(id);
        user.setPassword(entryptPassword(newPassword));
        userDao.updatePasswordById(user);
        // 清除用户缓存
        user.setLoginName(loginName);
        UserUtils.clearCache(user);
    }

    /**
     * @Author 阁楼麻雀
     * @Date 2017/4/28 14:21
     * @Desc 查询所有权限
     */
    public List<SysRole> findAllRole() {
        return UserUtils.getRoleList();
    }

    /**
     * @Author 阁楼麻雀
     * @Date 2017/4/28 14:20
     * @Desc 删除用户
     */
    public void deleteUser(SysUser user) {
        userDao.delete(user);
        UserUtils.clearCache(user);
    }
    /**
     * @Author 阁楼麻雀
     * @Date 2017/4/28 14:20
     * @Desc 分页查询用户列表
     */
    public Page<SysUser> findUser(Page<SysUser> page, SysUser user) {
        // 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
        user.getSqlMap().put("dsf", dataScopeFilter(user.getCurrentUser(), "o", "a"));
        // 设置分页参数
        user.setPage(page);
        // 执行分页查询
        page.setList(userDao.findList(user));
        return page;
    }

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword);
    }
    /**
     * 获取Key加载信息
     */
    public static boolean printKeyLoadMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n    欢迎使用 "+ Global.getConfig("productName")+"  - 麻雀虽小，五脏俱全\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        return true;
    }
}
