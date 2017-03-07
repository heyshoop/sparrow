package cn.sheetanchor.sparrow.sys.controller;

import cn.sheetanchor.common.config.Global;
import cn.sheetanchor.common.utils.StringUtils;
import cn.sheetanchor.common.web.BaseController;
import cn.sheetanchor.sparrow.sys.model.SysOffice;
import cn.sheetanchor.sparrow.sys.service.OfficeService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/3/7
 * @Desc 组织机构controller
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/office")
public class sysOfficeController extends BaseController {
    @Resource
    private OfficeService officeService;

    /**
     * 获取机构JSON数据。
     * @param extId 排除的ID
     * @param type	类型（1：公司；2：部门/小组/其它：3：用户）
     * @param grade 显示级别
     * @param response
     * @return
     */
    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, @RequestParam(required=false) String type,
                                              @RequestParam(required=false) Long grade, @RequestParam(required=false) Boolean isAll, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<SysOffice> list = officeService.findList(isAll);
        for (int i=0; i<list.size(); i++){
            SysOffice e = list.get(i);
            if ((StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1))
                    && (type == null || (type != null && (type.equals("1") ? type.equals(e.getType()) : true)))
                    && (grade == null || (grade != null && Integer.parseInt(e.getGrade()) <= grade.intValue()))
                    && Global.YES.equals(e.getUseable())){
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", e.getId());
                map.put("pId", e.getParentId());
                map.put("pIds", e.getParentIds());
                map.put("name", e.getName());
                if (type != null && "3".equals(type)){
                    map.put("isParent", true);
                }
                mapList.add(map);
            }
        }
        return mapList;
    }
}
