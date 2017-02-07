package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.sparrow.sys.model.SysOffice;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/7
 * @Desc 部门Dao
 */
public interface OfficeDao {
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/7 16:18
     * @Desc 查询所有部门
     */
    List<SysOffice> findAllList();
}
