package cn.sheetanchor.sparrow.sys.service;

import cn.sheetanchor.sparrow.sys.model.SysOffice;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/3/7
 * @Desc 组织机构
 */
public interface OfficeService {
    /**
     * @Author 阁楼麻雀
     * @Date 2017/3/7 13:37
     * @Desc 组织机构-查询列表
     */
    List<SysOffice> findList(Boolean isAll);
}
