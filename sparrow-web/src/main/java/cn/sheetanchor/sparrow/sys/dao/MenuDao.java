package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.common.persistence.BaseDao;
import cn.sheetanchor.common.persistence.annotation.MyBatisDao;
import cn.sheetanchor.sparrow.sys.model.SysMenu;

import java.util.List;


/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc 菜单Dao
 */
@MyBatisDao
public interface MenuDao extends BaseDao<SysMenu> {

    /**
     * @Author 阁楼麻雀
     * @Date 2017/4/27 16:12
     * @Desc 通过用户ID查询菜单
     */
    public List<SysMenu> findByUserId(SysMenu menu);

}
