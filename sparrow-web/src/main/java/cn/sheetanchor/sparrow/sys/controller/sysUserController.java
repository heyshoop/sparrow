package cn.sheetanchor.sparrow.sys.controller;

import cn.sheetanchor.common.config.Global;
import cn.sheetanchor.common.utils.StringUtils;
import cn.sheetanchor.common.utils.UserUtils;
import cn.sheetanchor.common.web.BaseController;
import cn.sheetanchor.sparrow.sys.model.SysUser;
import cn.sheetanchor.sparrow.sys.service.SystemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/25
 * @Desc 用户controller
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class sysUserController extends BaseController{

    @Resource
    private SystemService systemService;

    @ModelAttribute
    public SysUser get(@RequestParam(required=false) String id) {
        if (StringUtils.isNotBlank(id)){
            return systemService.getUser(id);
        }else{
            return new SysUser();
        }
    }

    /**
     * @Author 阁楼麻雀
     * @Date 2017/2/25 11:26
     * @Desc 查询显示/保存用户信息
     */
    @RequiresPermissions("user")
    @RequestMapping(value = "info")
    public String info(SysUser user, HttpServletResponse response, Model model) {
        SysUser currentUser = UserUtils.getUser();
        if (StringUtils.isNotBlank(user.getName())){
            currentUser.setEmail(user.getEmail());
            currentUser.setPhone(user.getPhone());
            currentUser.setMobile(user.getMobile());
            currentUser.setRemarks(user.getRemarks());
            currentUser.setPhoto(user.getPhoto());
            systemService.updateUserInfo(currentUser);
            model.addAttribute("message", "保存用户信息成功");
        }
        model.addAttribute("user", currentUser);
        model.addAttribute("Global", new Global());
        return "include/sys/userInfo";
    }

}
