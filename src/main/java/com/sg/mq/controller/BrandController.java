package com.sg.mq.controller;

import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.BrandParam;
import com.sg.mq.domain.query.BrandQuery;
import com.sg.mq.domain.vo.BrandVo;
import com.sg.mq.service.IBrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Brand", description = "品牌管理")
@RestController
@RequestMapping("Brand")
public class BrandController extends BaseController{

    @Autowired
    IBrandService brandService;

    @Operation(summary = "获取品牌",description = "获取品牌明细")
    @GetMapping(value = "get")
    public JResult<BrandVo> getBrandById(@RequestParam String id) {
        BrandVo Brand = brandService.getById(id);
        return success(Brand);
    }

    @GetMapping(value = "page")
    public JResult<PageResult<BrandVo>> queryList(BrandQuery q) {
        PageResult<BrandVo> result = brandService.queryList(q);
        return success(result);
    }

    @Operation(summary = "添加品牌")
    @PostMapping(value = "add")
    public JResult<BrandParam> addBrand(@RequestBody @Validated BrandParam param) {
        final boolean insert = brandService.insert(param);
        return success(param);
    }

    @Operation(summary = "删除品牌")
    @DeleteMapping(value = "delete")
    public JResult deleteBrand(String id) {
        final boolean b = brandService.deleteById(id);
        return success();
    }

}
