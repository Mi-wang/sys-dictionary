package cn.wolfcode.controller;


import cn.wolfcode.entity.Customer;
import cn.wolfcode.qo.CustomerQuery;
import cn.wolfcode.service.ICustomerService;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.vo.JsonResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wang
 * @since 2022-11-07
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping
    public JsonResult<IPage<Customer>> query(CustomerQuery qo) {
        return JsonResult.success(service.queryPage(qo));
    }

    @PostMapping
    public JsonResult<?> save(Customer module) {
        service.save(module);
        return JsonResult.success();
    }

    @PutMapping
    public JsonResult<?> updateById(Customer module) {
        service.updateById(module);
        return JsonResult.success();
    }

    @DeleteMapping("/{id}")
    public JsonResult<?> deleteById(@PathVariable Long id) {
        service.removeById(id);
        return JsonResult.success();
    }

}
