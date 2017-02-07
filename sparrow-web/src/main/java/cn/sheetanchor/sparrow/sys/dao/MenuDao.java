package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.sparrow.sys.model.SysMenu;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc 菜单Dao
 */
public interface MenuDao {

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/7 15:13
     * @Desc 查询所有菜单
     */
    public List<SysMenu> findAllList();

}
