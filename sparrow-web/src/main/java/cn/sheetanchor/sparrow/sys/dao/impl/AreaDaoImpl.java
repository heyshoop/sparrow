package cn.sheetanchor.sparrow.sys.dao.impl;

import cn.sheetanchor.common.hibernate.HibernateBaseDao;
import cn.sheetanchor.sparrow.sys.dao.AreaDao;
import cn.sheetanchor.sparrow.sys.model.SysArea;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/7
 * @Desc
 */
@Repository
public class AreaDaoImpl extends HibernateBaseDao<SysArea,String> implements AreaDao{
    @Override
    protected Class<SysArea> getEntityClass() {
        return SysArea.class;
    }


    @Override
    public List<SysArea> findAllList() {
        String hql = "from SysArea bean where bean.delFlag = '0' order by bean.code";
        Query query = getSession().createQuery(hql);
        return query.list();
    }
}
