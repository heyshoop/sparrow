package cn.sheetanchor.sparrow.sys.dao;

import cn.sheetanchor.sparrow.sys.model.SysDict;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/2/4
 * @Desc 字典dao
 */
public interface DictDao {

    public List<String> findTypeList(SysDict dict);

    public List<SysDict> findAllList();
}
