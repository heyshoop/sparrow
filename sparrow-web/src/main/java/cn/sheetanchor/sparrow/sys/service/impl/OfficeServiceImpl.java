package cn.sheetanchor.sparrow.sys.service.impl;

import cn.sheetanchor.common.utils.UserUtils;
import cn.sheetanchor.sparrow.sys.model.SysOffice;
import cn.sheetanchor.sparrow.sys.service.OfficeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 阁楼麻雀
 * @Email netuser.orz@icloud.com
 * @Date 2017/3/7
 * @Desc
 */
@Service
@Transactional(readOnly = true)
public class OfficeServiceImpl implements OfficeService{
    @Override
    public List<SysOffice> findList(Boolean isAll) {
        if (isAll != null && isAll){
            return UserUtils.getOfficeAllList();
        }else{
            return UserUtils.getOfficeList();
        }
    }
}
