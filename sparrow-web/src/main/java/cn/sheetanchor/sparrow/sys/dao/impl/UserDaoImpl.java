package cn.sheetanchor.sparrow.sys.dao.impl;

import cn.sheetanchor.common.hibernate.HibernateBaseDao;
import cn.sheetanchor.sparrow.sys.dao.UserDao;
import cn.sheetanchor.sparrow.sys.model.SysUser;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc
 */
public class UserDaoImpl extends HibernateBaseDao<SysUser,Integer> implements UserDao{
    @Override
    protected Class<SysUser> getEntityClass() {
        return SysUser.class;
    }

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/6 15:27
     * @Desc 通过ID查找用户信息
     */
    public SysUser findById(Integer id) {
        SysUser entity = get(id);
        return entity;
    }

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/6 15:32
     * @Desc 根据登录名查询用户信息
     */
    public SysUser findByLoginName(String loginName) {
        return findUniqueByProperty("loginName", loginName);
    }
}
