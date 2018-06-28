package com.xiang.core.service;

import com.xiang.core.entity.Goods;

import java.util.List;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 17:01.
 */
public interface GoodsService {
    Goods queryGoodsByGoodsId(String goodsId);

    List<Goods> findAllValidDataByCondition();
}
