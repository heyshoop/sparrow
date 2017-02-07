package cn.sheetanchor.sparrow.sys.dao.impl;

import cn.sheetanchor.common.hibernate.HibernateBaseDao;
import cn.sheetanchor.sparrow.sys.dao.OfficeDao;
import cn.sheetanchor.sparrow.sys.model.SysOffice;
import org.hibernate.Query;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/7
 * @Desc
 */
public class OfficeDaoImpl extends HibernateBaseDao<SysOffice,Integer> implements OfficeDao{
    @Override
    protected Class<SysOffice> getEntityClass() {
        return SysOffice.class;
    }


    @Override
    public List<SysOffice> findAllList() {
        String hql = "from SysOffice bean where bean.delFlag = '0' order by bean.code";
        Query query = getSession().createQuery(hql);
        return query.list();
    }
}
