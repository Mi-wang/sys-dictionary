package cn.wolfcode.service;

import cn.wolfcode.entity.DictType;
import cn.wolfcode.qo.QueryObject;
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
public interface IDictTypeService extends IService<DictType> {

    Page<DictType> page(QueryObject qo);
}
