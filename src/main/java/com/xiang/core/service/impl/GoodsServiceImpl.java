package com.xiang.core.service.impl;

import com.xiang.core.dao.GoodsRepository;
import com.xiang.core.entity.Goods;
import com.xiang.core.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        Goods goods = goodsRepository.findById(String.valueOf(goodsId)).get();
        return goods;
    }

    @Override
    public List<Goods> findAllValidDataByCondition() {
        return (List<Goods>) goodsRepository.findAll();
    }
}
