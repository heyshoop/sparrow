package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.common.persistence.BaseDao;
import cn.sheetanchor.common.persistence.annotation.MyBatisDao;
import cn.sheetanchor.sparrow.sys.model.SysUser;


/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/6
 * @Desc 用户Dao
 */
@MyBatisDao
public interface UserDao extends BaseDao<SysUser>{

    /**
     * 根据登录名称查询用户
     * @param user
     * @return
     */
    public SysUser getByLoginName(SysUser user);

    /**
     * 更新登录信息，如：登录IP、登录时间
     * @param user
     * @return
     */
    public int updateLoginInfo(SysUser user);

    /**
     * 更新用户密码
     * @param user
     * @return
     */
    public int updatePasswordById(SysUser user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUserInfo(SysUser user);
}
