package cn.wolfcode.service;

import cn.wolfcode.entity.DictData;
import cn.wolfcode.entity.DictType;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.vo.DictItemQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoliu
 * @since 2022-11-07
 */
public interface IDictDataService extends IService<DictData> {

    Page<DictData> page(DictItemQuery qo);
}
