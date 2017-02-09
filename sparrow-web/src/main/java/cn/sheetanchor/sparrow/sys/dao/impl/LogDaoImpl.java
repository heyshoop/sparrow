package cn.sheetanchor.sparrow.sys.dao.impl;

import cn.sheetanchor.common.hibernate.HibernateBaseDao;
import cn.sheetanchor.sparrow.sys.dao.LogDao;
import cn.sheetanchor.sparrow.sys.model.SysLog;
import org.springframework.stereotype.Repository;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc
 */
@Repository
public class LogDaoImpl extends HibernateBaseDao<SysLog,String> implements LogDao{

    @Override
    public SysLog save(SysLog bean) {
        getSession().save(bean);
        return bean;
    }




    @Override
    protected Class<SysLog> getEntityClass() {
        return SysLog.class;
    }
}
