package cn.sheetanchor.sparrow.sys.service.impl;

import cn.sheetanchor.common.utils.*;
import cn.sheetanchor.sparrow.sys.dao.*;
import cn.sheetanchor.sparrow.sys.model.SysUser;
import cn.sheetanchor.sparrow.sys.service.SystemService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

import static cn.sheetanchor.common.security.SystemAuthorizingRealm.HASH_INTERATIONS;
import static cn.sheetanchor.common.security.SystemAuthorizingRealm.SALT_SIZE;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/7
 * @Desc
 */
@Service
@Transactional
public class SystemServiceImpl implements SystemService,InitializingBean {

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

    public void updateUserLoginInfo(SysUser user) {
        // 更新本次登录信息
        user.setLoginIp(StringUtils.getRemoteAddr(Servlets.getRequest()));
        user.setLoginDate(new Date());
        userDao.update(user);
    }

    public SysUser getUser(String id) {
        return UserUtils.get(id);
    }

    @Transactional(readOnly = false)
    public void updateUserInfo(SysUser currentUser) {
        SysUser user = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getId())){
            currentUser.setUpdateBy(user.getId());
        }
        currentUser.setUpdateDate(new Date());
        userDao.update(currentUser);
    }

    public boolean validatePassword(String oldPassword, String password) {
        String plain = Encodes.unescapeHtml(oldPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0,16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
    }

    @Transactional(readOnly = false)
    public void updatePasswordById(String id, String loginName, String newPassword) {
        SysUser user = userDao.findById(id);
        user.setPassword(entryptPassword(newPassword));
        userDao.update(user);
        // 清除用户缓存
        user.setLoginName(loginName);
        UserUtils.clearCache(user);
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
}
