package com.sg.mq.controller;

import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.CategoryParam;
import com.sg.mq.domain.query.CategoryQuery;
import com.sg.mq.domain.vo.CategoryVo;
import com.sg.mq.service.ICategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "category", description = "品类管理")
@RestController
@RequestMapping("category")
public class CategoryController extends BaseController{

    @Autowired
    ICategoryService categoryService;

    @Operation(summary = "获取品类",description = "获取品类明细")
    @GetMapping(value = "get")
    public JResult<CategoryVo> getCategoryById(@RequestParam String id) {
        CategoryVo Category = categoryService.getById(id);
        return success(Category);
    }

    @GetMapping(value = "page")
    public JResult<PageResult<CategoryVo>> queryList(CategoryQuery q) {
        PageResult<CategoryVo> result = categoryService.queryList(q);
        return success(result);
    }

    @Operation(summary = "添加品类")
    @PostMapping(value = "add")
    public JResult<CategoryParam> addCategory(@RequestBody @Validated CategoryParam param) {
        final boolean insert = categoryService.insert(param);
        return success(param);
    }

    @Operation(summary = "删除品类")
    @DeleteMapping(value = "delete")
    public JResult deleteCategory(String id) {
        final boolean b = categoryService.deleteById(id);
        return success();
    }

}
