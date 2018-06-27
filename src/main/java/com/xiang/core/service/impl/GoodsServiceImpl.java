package com.xiang.core.service.impl;

import com.xiang.core.dao.GoodsRepository;
import com.xiang.core.entity.Goods;
import com.xiang.core.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 17:01.
 */
@Repository
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods queryGoodsByGoodsId(String goodsId) {
        return goodsRepository.findById(String.valueOf(goodsId)).get();
    }
}
