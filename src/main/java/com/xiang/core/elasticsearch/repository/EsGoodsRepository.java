package com.xiang.core.elasticsearch.repository;

import com.xiang.core.elasticsearch.entity.EsGoods;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 16:52.
 */
public interface EsGoodsRepository extends ElasticsearchCrudRepository<EsGoods, String>{
}
