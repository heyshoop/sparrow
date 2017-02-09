package cn.sheetanchor.sparrow.sys.dao.impl;

import cn.sheetanchor.common.hibernate.HibernateBaseDao;
import cn.sheetanchor.sparrow.sys.dao.RoleDao;
import cn.sheetanchor.sparrow.sys.model.SysRole;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc
 */
@Repository
public class RoleDaoImpl extends HibernateBaseDao<SysRole,String> implements RoleDao{
    @Override
    protected Class<SysRole> getEntityClass() {
        return SysRole.class;
    }


    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/6 16:37
     * @Desc 超级管理员登录时查询所有角色
     */
    public List<SysRole> findAllList() {
        String hql = "from SysRole bean where bean.delFlag = '0' order by bean.id";
        Query query = getSession().createQuery(hql);
        return query.list();
    }
}
