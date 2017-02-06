package cn.sheetanchor.sparrow.sys.dao.impl;

import cn.sheetanchor.common.hibernate.HibernateBaseDao;
import cn.sheetanchor.sparrow.sys.dao.DictDao;
import cn.sheetanchor.sparrow.sys.model.SysDict;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc
 */
@Repository
public class DictDaoImpl extends HibernateBaseDao<SysDict,Integer> implements DictDao {

    public List<String> findTypeList(SysDict dict) {
        return null;
    }

    public List<SysDict> findAllList() {
        String hql = "from SysDict bean where bean.delFlag = '0' order by bean.type,bean.sort,bean.update_date DESC";
        Query query = getSession().createQuery(hql);
        return query.list();
    }



    @Override
    protected Class<SysDict> getEntityClass() {
        return SysDict.class;
    }
}
