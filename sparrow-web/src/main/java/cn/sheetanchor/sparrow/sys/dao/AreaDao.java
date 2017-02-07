package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.sparrow.sys.model.SysArea;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/7
 * @Desc 区域Dao
 */
public interface AreaDao {
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/7 16:09
     * @Desc 查询所有区域
     */
    List<SysArea> findAllList();
}
