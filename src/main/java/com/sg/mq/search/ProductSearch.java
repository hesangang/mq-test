package com.sg.mq.search;

import cn.hutool.core.util.StrUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.util.ObjectBuilder;
import com.sg.mq.domain.entity.MdProduct;
import com.sg.mq.domain.entity.SysUser;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.query.ProductQuery;
import com.sg.mq.domain.query.UserQuery;
import com.sg.mq.domain.vo.CategoryVo;
import com.sg.mq.domain.vo.ProductVo;
import com.sg.mq.domain.vo.UserVo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductSearch {

    @Autowired
    private ElasticsearchClient client;

    //索引别名
    String INDEX_NAME = "md_product_alias";

    @SneakyThrows
    public ProductVo getById(String id) {
        GetResponse<MdProduct> response = client.get(builder -> builder.index(INDEX_NAME).id(id), MdProduct.class);
        if (response.found()) {
            log.info(response.source().toString());
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(response.source(), vo);
            return vo;
        }
        return null;
    }

    @SneakyThrows
    public PageResult<ProductVo> queryList(ProductQuery query) {
        SearchResponse<CategoryVo> response = client.search(_0 -> _0
                        .index(INDEX_NAME)
                        //.source(_1 -> _1.fetch(false))
                        //.fields(_1 -> _1.field("category_name"))
                        //.fields(_1 -> _1.field("update_time"))
                        .query(_1 -> {
                            buildSearch(query,_1);
                            return _1;
                        })
                        .from(query.getPage())
                        .size(query.getPageSize())
                , CategoryVo.class);

        TotalHits total = response.hits().total();
        List<Hit<CategoryVo>> hits = response.hits().hits();
        List<CategoryVo> list  = new ArrayList<>();
        for(Hit<CategoryVo> hit : hits){
            CategoryVo entity = hit.source();
            List<Hit<JsonData>> hitList = hit.innerHits().get("productList").hits().hits();
            list.add(entity);
        }

        return new PageResult(total.value(),list);
    }

    private String createPit() throws Exception {
        OpenPointInTimeResponse re = client
                .openPointInTime(_0 -> _0
                        .index(INDEX_NAME)
                        .keepAlive(_1 -> _1
                                .time("10m")));
        return re.id();
    }

    public PageResult<ProductVo> searchAfterBegin(ProductQuery query) throws Exception {
        String pitId = createPit();
        SearchResponse<ProductVo> response = client.search(_0 -> _0
                        .size(query.getPageSize())
                        .query(_1 -> {
                            buildSearch(query,_1);
                            return _1;
                        })
                        .pit(_1 -> _1
                                .id(pitId)
                                .keepAlive(_2 -> _2
                                        .time("10m")))
                        .sort(_1 -> _1
                                .field(_2 -> _2
                                        .field("create_time")
                                        .order(SortOrder.Desc)
                                        .field("id.keyword")
                                        .order(SortOrder.Asc)))
                , ProductVo.class);

        TotalHits total = response.hits().total();
        List<Hit<ProductVo>> hits = response.hits().hits();
        List<String> sort = null;
        List<ProductVo> list  = new ArrayList<>();
        for(int i=0;i<hits.size();i++){
            ProductVo entity = hits.get(i).source();
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(entity, vo);
            list.add(vo);
            if(i == hits.size()-1){
                sort = hits.get(i).sort();
            }
        }
        log.info(response.toString());
        return new PageResult(pitId,sort,total.value(),list);
    }

    public PageResult<ProductVo> searchAfterProcess(ProductQuery query) throws IOException {
        SearchResponse<ProductVo> response = client.search(_0 -> _0
                        .size(query.getPageSize())
                        .query(_1 -> {
                            buildSearch(query,_1);
                            return _1;
                        })
                        .pit(_1 -> _1
                                .id(query.getPitId())
                                .keepAlive(_2 -> _2
                                        .time("10m")))
                        .searchAfter(query.getLastSort())
                        .sort(_1 -> _1
                                .field(_2 -> _2
                                        .field("create_time")
                                        .order(SortOrder.Desc)
                                        .field("id.keyword")
                                        .order(SortOrder.Asc)))
                , ProductVo.class);

        TotalHits total = response.hits().total();
        List<Hit<ProductVo>> hits = response.hits().hits();
        List<String> sort = null;
        List<ProductVo> list  = new ArrayList<>();
        for(int i=0;i<hits.size();i++){
            ProductVo entity = hits.get(i).source();
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(entity, vo);
            list.add(vo);
            if(i == hits.size()-1){
                sort = hits.get(i).sort();
            }
        }

        log.info(response.toString());
        return new PageResult(query.getPitId(),sort,total.value(),list);
    }

    public PageResult<ProductVo> scrollBegin(ProductQuery query) throws Exception {
        SearchResponse<ProductVo> response = client.search(_0 -> _0
                        .index(INDEX_NAME)
                        .scroll(_1 -> _1
                                .time("10m"))
                        .size(5)
                        .query(_1 -> {
                            buildSearch(query,_1);
                            return _1;
                        })
                , ProductVo.class);
        TotalHits total = response.hits().total();
        List<Hit<ProductVo>> hits = response.hits().hits();
        List<ProductVo> list  = new ArrayList<>();
        for(int i=0;i<hits.size();i++){
            ProductVo entity = hits.get(i).source();
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(entity, vo);
            list.add(vo);
        }
        return new PageResult(response.scrollId(),total.value(),list);
    }

    public PageResult<ProductVo> scrollProcess(ProductQuery query) throws Exception {
        ScrollResponse<ProductVo> response = client.scroll(_0 -> _0
                        .scrollId(query.getPitId())
                        .scroll(_1 -> _1
                                .time("10m"))
                , ProductVo.class);
        TotalHits total = response.hits().total();
        List<Hit<ProductVo>> hits = response.hits().hits();
        List<ProductVo> list  = new ArrayList<>();
        for(int i=0;i<hits.size();i++){
            ProductVo entity = hits.get(i).source();
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(entity, vo);
            list.add(vo);
        }
        return new PageResult(response.scrollId(),total.value(),list);
    }



    //构建查询对象
    private void buildSearch(ProductQuery query, Query.Builder searchBuilder){

        BoolQuery boolQuery = BoolQuery.of(b ->{
            //关键词匹配
            if(StrUtil.isNotEmpty(query.getCateName())){
                b.must((q -> {
                    ObjectBuilder<Query> queryObjectBuilder = q.multiMatch(t -> t.fields("category_name", "category_code")
                            .query(query.getCateName()));

                    return queryObjectBuilder;
                }));
            }
            if(StrUtil.isNotEmpty(query.getBrandName())){
                b.must((q -> q.hasChild(t ->
                        t.type("product").query(m ->
                                        m.match(x -> x.field("brand_name").query(query.getBrandName())))
                                .innerHits(h ->h.name("productList"))
                )));
            }
            //精确查找
            if(Objects.nonNull(query.getProductCode())){
                b.must(TermQuery.of(m -> m.field("product_code").value(query.getProductCode()))
                        ._toQuery());
            }
            //范围查找
            if(Objects.nonNull(query.getUpdateTimeMin())){
                b.must(RangeQuery.of(m -> m.field("update_time")
                                .gte(JsonData.of(query.getUpdateTimeMin())))
                        ._toQuery());
            }
            if(Objects.nonNull(query.getUpdateTimeMax())){
                b.must(RangeQuery.of(m -> m.field("update_time")
                                .lt(JsonData.of(query.getUpdateTimeMax())))
                        ._toQuery());
            }
            return b;
        });
        searchBuilder.bool(boolQuery);
        String dsl1 = boolQuery.toString();
        log.info(dsl1);
    }

    //构建查询对象
    private void buildSearch(ProductQuery query, SearchRequest.Builder searchBuilder){

        BoolQuery boolQuery = BoolQuery.of(b ->{
            //关键词匹配
            if(StrUtil.isNotEmpty(query.getCateName())){
                b.must((q -> {
                    ObjectBuilder<Query> queryObjectBuilder = q.multiMatch(t -> t.fields("category_name", "category_code")
                            .query(query.getCateName()));

                    return queryObjectBuilder;
                }));
            }
            if(StrUtil.isNotEmpty(query.getBrandName())){
                b.must((q -> q.hasChild(t ->
                    t.type("product").query(m ->
                            m.match(x -> x.field("brand_name").query(query.getBrandName())))
                            .innerHits(h ->h.name("productList"))
                )));
            }
            //精确查找
            /*if(Objects.nonNull(query.getProductCode())){
                b.must(TermQuery.of(m -> m.field("product_code").value(query.getProductCode()))
                        ._toQuery());
            }
            //范围查找
            if(Objects.nonNull(query.getUpdateTimeMin())){
                b.must(RangeQuery.of(m -> m.field("update_time")
                                .gte(JsonData.of(query.getUpdateTimeMin())))
                        ._toQuery());
            }
            if(Objects.nonNull(query.getUpdateTimeMax())){
                b.must(RangeQuery.of(m -> m.field("update_time")
                                .lt(JsonData.of(query.getUpdateTimeMin())))
                        ._toQuery());
            }*/
            return b;
        });
        searchBuilder.query(q ->q.bool(boolQuery));
    }


}
