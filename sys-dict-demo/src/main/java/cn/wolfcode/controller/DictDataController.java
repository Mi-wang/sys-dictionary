package cn.wolfcode.controller;


import cn.wolfcode.entity.DictData;
import cn.wolfcode.service.IDictDataService;
import cn.wolfcode.qo.QueryObject;
import cn.wolfcode.vo.DictItemQuery;
import cn.wolfcode.vo.JsonResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wang
 * @since 2022-11-07
 */
@RestController
@RequestMapping("/dict/items")
public class DictDataController {

    @Autowired
    private IDictDataService service;

    @GetMapping
    public JsonResult<Page<DictData>> query(DictItemQuery qo) {
        return JsonResult.success(service.page(qo));
    }

    @GetMapping("/{type}")
    public JsonResult<List<DictData>> getListByType(@PathVariable("type") String dictType) {
        List<DictData> dataList = service.list(new QueryWrapper<DictData>().eq("dict_type", dictType).orderByAsc("seq"));
        return JsonResult.success(dataList);
    }

    @PostMapping
    public JsonResult<?> save(DictData module) {
        service.save(module);
        return JsonResult.success();
    }

    @PutMapping
    public JsonResult<?> updateById(DictData module) {
        service.updateById(module);
        return JsonResult.success();
    }

    @DeleteMapping("/{id}")
    public JsonResult<?> deleteById(@PathVariable Long id) {
        service.removeById(id);
        return JsonResult.success();
    }

}
