package cn.wolfcode.service.impl;

import cn.wolfcode.entity.DictType;
import cn.wolfcode.mapper.DictTypeMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IDictTypeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xiaoliu
 * @since 2022-11-07
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements IDictTypeService {

    @Override
    public Page<DictType> page(QueryObject qo) {
        LambdaQueryWrapper<DictType> wrapper = Wrappers.lambdaQuery();
        // 构建查询条件
        wrapper.like(qo.getKeyword() != null, DictType::getName, qo.getKeyword());

        return super.page(new Page<>(qo.getCurrent(), qo.getSize()), wrapper);
    }
}
