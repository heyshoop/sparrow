package cn.sheetanchor.common.utils.excel.fieldtype;

import cn.sheetanchor.common.utils.Collections3;
import cn.sheetanchor.common.utils.SpringContextHolder;
import cn.sheetanchor.common.utils.StringUtils;
import cn.sheetanchor.sparrow.sys.model.SysRole;
import cn.sheetanchor.sparrow.sys.service.SystemService;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Date 2017/4/27 14:50
 * @Desc 字段类型转换
 */

public class RoleListType {

	private static SystemService systemService = SpringContextHolder.getBean(SystemService.class);
	
	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		List<SysRole> roleList = Lists.newArrayList();
		List<SysRole> allRoleList = systemService.findAllRole();
		for (String s : StringUtils.split(val, ",")){
			for (SysRole e : allRoleList){
				if (StringUtils.trimToEmpty(s).equals(e.getName())){
					roleList.add(e);
				}
			}
		}
		return roleList.size()>0?roleList:null;
	}

	/**
	 * 设置对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null){
			@SuppressWarnings("unchecked")
			List<SysRole> roleList = (List<SysRole>)val;
			return Collections3.extractToString(roleList, "name", ", ");
		}
		return "";
	}
	
}
