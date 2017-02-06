package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.sparrow.sys.model.SysUser;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc 用户Dao
 */
public interface UserDao {
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/6 15:27
     * @Desc 通过ID查找用户信息
     */
    public SysUser findById(Integer id);

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/6 15:32
     * @Desc 根据登录名查询用户信息
     */
    public SysUser findByLoginName(String loginName);
}
