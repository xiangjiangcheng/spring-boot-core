package com.xiang.core.elasticsearch.rest;

import com.xiang.core.dao.GoodsRepository;
import com.xiang.core.elasticsearch.entity.EsGoods;
import com.xiang.core.elasticsearch.repository.EsGoodsRepository;
import com.xiang.core.entity.Goods;
import com.xiang.core.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 商品控制器
 *
 * restful 风格接口
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 16:53.
 */

@RestController
public class EsGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(EsGoodsController.class);

    @Autowired
    private EsGoodsRepository esGoodsRepository;

    @Autowired
    private GoodsService goodsService;

    /**
     * 添加一行数据到es   如果里面没有配置的index  会自动创建
     */
    @RequestMapping(value = "/esGoods/a_goods", method = {RequestMethod.POST})
    public ResponseEntity addItem(@RequestBody EsGoods esGoods) {
        String goodsId = esGoods.getGoodsId();
        Goods goods = goodsService.queryGoodsByGoodsId(goodsId);
        if (goods == null) {
            // TODO: 2018/6/27  抛自定义异常 商品不存在
        }

        BeanUtils.copyProperties(goods, esGoods);
        esGoodsRepository.save(esGoods);
        return new ResponseEntity(esGoods.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/esGoods/{id}",method = {RequestMethod.GET})
    public ResponseEntity getItem(@PathVariable("id") String id) {
        EsGoods esGoods = esGoodsRepository.findById(id).get();
        return new ResponseEntity(esGoods.toString(), HttpStatus.OK);
    }




}
