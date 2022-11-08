package cn.wolfcode.controller;


import cn.wolfcode.entity.DictType;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.service.IDictTypeService;
import cn.wolfcode.vo.JsonResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xiaoliu
 * @since 2022-11-07
 */
@RestController
@RequestMapping("/dict/types")
public class DictTypeController {

    @Autowired
    private IDictTypeService service;

    @GetMapping
    public JsonResult<Page<DictType>> query(QueryObject qo) {
        return JsonResult.success(service.page(qo));
    }

    @GetMapping("/{type}")
    public JsonResult<DictType> getByType(@PathVariable String type) {
        DictType dict = service.getOne(new QueryWrapper<DictType>().eq("type", type));
        return JsonResult.success(dict);
    }

    @PostMapping
    public JsonResult<?> save(DictType module) {
        service.save(module);
        return JsonResult.success();
    }

    @PutMapping
    public JsonResult<?> updateById(DictType module) {
        service.updateById(module);
        return JsonResult.success();
    }

    @DeleteMapping("/{id}")
    public JsonResult<?> deleteById(@PathVariable Long id) {
        service.removeById(id);
        return JsonResult.success();
    }

}
