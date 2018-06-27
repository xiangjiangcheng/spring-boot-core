package com.xiang.core.controller;

import com.xiang.core.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 商品控制器
 *
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 17:09.
 */

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
}
