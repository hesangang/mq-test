package com.sg.mq.search;

import cn.hutool.core.util.StrUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.util.ObjectBuilder;
import com.sg.mq.domain.entity.MdProduct;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.query.ProductQuery;
import com.sg.mq.domain.vo.ProductVo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductSearch {

    @Autowired
    private ElasticsearchClient client;

    String INDEX_NAME = "md_product";

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
        SearchResponse<JsonData> response = client.search(s -> {
            SearchRequest.Builder searchBuilder = s.index(INDEX_NAME);
            buildSearch(query,searchBuilder);
            return searchBuilder;
        }, JsonData.class);

        TotalHits total = response.hits().total();
        List<Hit<JsonData>> hits = response.hits().hits();
        List<ProductVo> list  = new ArrayList<>();
        for(Hit<JsonData> hit : hits){
            JsonData entity = hit.source();
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(entity, vo);
            List<Hit<JsonData>> hitList = hit.innerHits().get("productList").hits().hits();
            list.add(vo);

        }

        log.info(response.toString());
        return new PageResult(total.value(),list);
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
