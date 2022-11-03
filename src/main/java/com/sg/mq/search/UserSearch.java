package com.sg.mq.search;

import cn.hutool.core.util.StrUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.TermQuery;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.json.JsonData;
import com.sg.mq.domain.entity.SysUser;
import com.sg.mq.domain.model.PageResult;
import com.sg.mq.domain.query.UserQuery;
import com.sg.mq.domain.vo.UserVo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class UserSearch {

    @Autowired
    private ElasticsearchClient client;

    String INDEX_NAME = "sys_user_idx";

    @SneakyThrows
    public UserVo getById(String id) {
        GetResponse<SysUser> response = client.get(builder -> builder.index(INDEX_NAME).id(id), SysUser.class);
        if (response.found()) {
            log.info(response.source().toString());
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(response.source(), vo);
            return vo;
        }
        return null;
    }

    @SneakyThrows
    public PageResult<UserVo> queryList(UserQuery query) {
        SearchResponse<SysUser> response = client.search(s -> {
            SearchRequest.Builder searchBuilder = s.index(INDEX_NAME);
            buildSearch(query,searchBuilder);
            return searchBuilder;
        }, SysUser.class);

        TotalHits total = response.hits().total();
        List<Hit<SysUser>> hits = response.hits().hits();
        List<UserVo> list  = new ArrayList<>();
        for(Hit<SysUser> hit : hits){
            SysUser entity = hit.source();
            UserVo vo = new UserVo();
            BeanUtils.copyProperties(entity, vo);
            list.add(vo);
        }

        log.info(response.toString());
        return new PageResult(total.value(),list);
    }

    //构建查询对象
    private void buildSearch(UserQuery query, SearchRequest.Builder searchBuilder){
        BoolQuery boolQuery = BoolQuery.of(b ->{
            //关键词匹配
            if(StrUtil.isNotEmpty(query.getUserName())){
                b.must((q -> q.multiMatch(t -> t.fields("user_name","nick_name")
                        .query(query.getUserName()))));
            }
            //精确查找
            if(Objects.nonNull(query.getPhone())){
                b.must(TermQuery.of(m -> m.field("phone").value(query.getPhone()))
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
            }
            return b;
        });
        searchBuilder.query(q ->q.bool(boolQuery));
    }


}
