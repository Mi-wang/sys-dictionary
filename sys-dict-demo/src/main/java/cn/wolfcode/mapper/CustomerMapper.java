package cn.wolfcode.mapper;

import cn.wolfcode.entity.Customer;
import cn.wolfcode.qo.QueryObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wang
 * @since 2022-11-07
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> selectForList(IPage<Customer> qo);
}
