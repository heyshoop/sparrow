package cn.sheetanchor.sparrow.sys.service;

import cn.sheetanchor.common.page.Page;
import cn.sheetanchor.sparrow.sys.model.SysRole;
import cn.sheetanchor.sparrow.sys.model.SysUser;

import java.util.List;

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
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/25 17:22
     * @Desc 验证密码
     */
    boolean validatePassword(String oldPassword, String password);
    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/25 17:26
     * @Desc 修改密码
     */
    void updatePasswordById(String id, String loginName, String newPassword);
    /**
     * @Author 阁楼麻雀
     * @Date 2017/3/1 17:51
     * @Desc 分页查询
     */
    Page<SysUser> getPageForUser(Page<SysUser> sysUserPage, SysUser user);
    /**
     * @Author 阁楼麻雀
     * @Date 2017/3/7 14:37
     * @Desc 查询角色
     */
    List<SysRole> findAllRole();
    /**
     * @Author 阁楼麻雀
     * @Date 2017/3/7 14:47
     * @Desc 删除用户
     */
    void deleteUser(SysUser user);
}
