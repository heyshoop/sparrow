package cn.sheetanchor.sparrow.sys.service.impl;

import cn.sheetanchor.common.utils.Servlets;
import cn.sheetanchor.common.utils.StringUtils;
import cn.sheetanchor.common.utils.UserUtils;
import cn.sheetanchor.sparrow.sys.dao.*;
import cn.sheetanchor.sparrow.sys.model.SysUser;
import cn.sheetanchor.sparrow.sys.service.SystemService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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
     * @return
     */
    public SysUser getUserByLoginName(String loginName) {
        return UserUtils.getByLoginName(loginName);
    }

    @Override
    public void updateUserLoginInfo(SysUser user) {
        // 更新本次登录信息
        user.setLoginIp(StringUtils.getRemoteAddr(Servlets.getRequest()));
        user.setLoginDate(new Date());
        userDao.update(user);
    }
}
