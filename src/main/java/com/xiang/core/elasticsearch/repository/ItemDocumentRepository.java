package com.xiang.core.elasticsearch.repository;


import com.xiang.core.elasticsearch.entity.ItemDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/
 * <p>
 * Created by lijingyao on 2018/1/15 11:03.
 */
public interface ItemDocumentRepository extends ElasticsearchRepository<ItemDocument, String> {


}
