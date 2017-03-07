package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.sparrow.sys.model.SysUser;

import java.util.List;

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
    public SysUser findById(String id);

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/6 15:32
     * @Desc 根据登录名查询用户信息
     */
    public SysUser findByLoginName(String loginName);

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/7 17:02
     * @Desc 更新用户信息
     */
    SysUser update(SysUser user);

    /**
     * @Author 阁楼麻雀
     * @Date 2017/3/7 14:48
     * @Desc 删除用户
     */
    SysUser delete(SysUser user);

    /**
     * @Author 阁楼麻雀
     * @Date 2017/3/7 16:36
     * @Desc 查询人员列表
     * @param user
     */
    List<SysUser> findList(SysUser user);
}
