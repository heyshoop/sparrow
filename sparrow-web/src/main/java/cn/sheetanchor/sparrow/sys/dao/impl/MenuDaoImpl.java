package cn.sheetanchor.sparrow.sys.dao.impl;

import cn.sheetanchor.common.hibernate.HibernateBaseDao;
import cn.sheetanchor.sparrow.sys.dao.MenuDao;
import cn.sheetanchor.sparrow.sys.model.SysMenu;
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
public class MenuDaoImpl extends HibernateBaseDao<SysMenu,String> implements MenuDao{

    public List<SysMenu> findAllList() {
        String hql = "from SysMenu bean where bean.delFlag = '0' order by bean.sort";
        Query query = getSession().createQuery(hql);
        return query.list();
    }


    @Override
    protected Class<SysMenu> getEntityClass() {
        return SysMenu.class;
    }


}
