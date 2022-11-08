package cn.wolfcode.service.impl;

import cn.wolfcode.entity.DictData;
import cn.wolfcode.entity.DictType;
import cn.wolfcode.mapper.DictDataMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IDictDataService;
import cn.wolfcode.vo.DictItemQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2022-11-07
 */
@Service
public class DictDataServiceImpl extends ServiceImpl<DictDataMapper, DictData> implements IDictDataService {


    @Override
    public Page<DictData> page(DictItemQuery qo) {
        QueryWrapper<DictData> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.hasText(qo.getDictType()),"dict_type",qo.getDictType());
        //
        wrapper.like(qo.getKeyword() != null,"label",qo.getKeyword());
        // 按照序号排序
        wrapper.orderByAsc("seq");
        return super.page( new Page<>(qo.getCurrent(), qo.getSize()),wrapper);
    }
}