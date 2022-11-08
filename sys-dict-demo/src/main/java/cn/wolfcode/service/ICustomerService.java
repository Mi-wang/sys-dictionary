package cn.wolfcode.service;

import cn.wolfcode.entity.Customer;
import cn.wolfcode.qo.QueryObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wang
 * @since 2022-11-07
 */
public interface ICustomerService extends IService<Customer> {

    IPage<Customer> queryPage(IPage<Customer> qo);
}
