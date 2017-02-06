package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.sparrow.sys.model.SysRole;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc 角色dao
 */
public interface RoleDao {
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/6 16:37
     * @Desc 查询所有角色
     */
    public List<SysRole> findAllList();
}
