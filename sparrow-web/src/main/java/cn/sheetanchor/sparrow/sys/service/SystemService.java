package cn.sheetanchor.sparrow.sys.service;

import cn.sheetanchor.sparrow.sys.model.SysUser;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/3
 * @Desc 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 */
public interface SystemService {

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/7 16:53
     * @Desc 校验用户名密码
     */
    SysUser getUserByLoginName(String username);
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/7 16:56
     * @Desc 更新登录IP和时间
     */
    void updateUserLoginInfo(SysUser user);
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/25 11:13
     * @Desc 获取用户信息
     */
    SysUser getUser(String id);
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/25 11:31
     * @Desc 更新用户信息
     */
    void updateUserInfo(SysUser currentUser);
}
