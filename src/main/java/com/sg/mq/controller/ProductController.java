package com.sg.mq.controller;

import com.sg.mq.domain.model.JResult;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.param.ProductParam;
import com.sg.mq.domain.query.ProductQuery;
import com.sg.mq.domain.vo.ProductVo;
import com.sg.mq.search.ProductSearch;
import com.sg.mq.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "product", description = "商品管理")
@RestController
@RequestMapping("product")
public class ProductController extends BaseController{

    @Autowired
    IProductService productService;

    @Autowired
    ProductSearch productSearch;

    @Operation(summary = "获取商品",description = "获取商品明细")
    @GetMapping(value = "get")
    public JResult<ProductVo> getProductById(@RequestParam String id) {
        ProductVo Product = productSearch.getById(id);
        return success(Product);
    }

    @GetMapping(value = "page")
    public JResult<PageResult<ProductVo>> queryList(ProductQuery q) {
        PageResult<ProductVo> result = productSearch.queryList(q);
        return success(result);
    }

    @GetMapping(value = "searchAfter")
    public JResult<PageResult<ProductVo>> searchAfter(ProductQuery q) throws Exception {
        if(q.getPitId() == null){
            PageResult<ProductVo> result = productSearch.searchAfterBegin(q);
            return success(result);
        }
        PageResult<ProductVo> result = productSearch.searchAfterProcess(q);
        return success(result);

    }

    @GetMapping(value = "scroll")
    public JResult<PageResult<ProductVo>> scroll(ProductQuery q) throws Exception {
        if(q.getPitId() == null){
            PageResult<ProductVo> result = productSearch.scrollBegin(q);
            return success(result);
        }
        PageResult<ProductVo> result = productSearch.scrollProcess(q);
        return success(result);

    }

    @Operation(summary = "添加商品")
    @PostMapping(value = "add")
    public JResult<ProductParam> addProduct(@RequestBody @Validated ProductParam param) {
        final boolean insert = productService.insert(param);
        return success(param);
    }

    @Operation(summary = "删除商品")
    @DeleteMapping(value = "delete")
    public JResult deleteProduct(String id) {
        final boolean b = productService.deleteById(id);
        return success();
    }

}
