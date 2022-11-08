package cn.wolfcode.service.impl;

import cn.wolfcode.entity.Customer;
import cn.wolfcode.mapper.CustomerMapper;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.ICustomerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2022-11-07
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public IPage<Customer> queryPage(IPage<Customer> qo) {
        List<Customer> customers = super.getBaseMapper().selectForList(qo);
        qo.setRecords(customers);
        return qo;
    }

}
