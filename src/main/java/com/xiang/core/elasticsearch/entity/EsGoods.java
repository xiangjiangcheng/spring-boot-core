package com.xiang.core.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Transient;
import java.util.Date;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 商品实体
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 16:37.
 */

@Data
@Document(indexName = EsGoods.INDEX, type = EsGoods.TYPE)
public class EsGoods {
    public static final String INDEX = "goods_index";
    public static final String TYPE = "goods_type";

    public EsGoods() {
    }

    public EsGoods(String goodsId, Integer gsType, Integer consuType, String goodsName, Long purchasePrice, Long moneyPrice, Long goldPrice, Long rebateMoney, Integer state, Date createAt, Date updateAt, String coverImg, String classifys, String bannerVideo, String goodsVideo, String goodsVideoImg, String goodsSpecImg, String coverImgDescription, String coverImgDescription2, Boolean hideFlag, Integer level, String bigImg, String bannerImg, String searchKeywords, String textDes, Integer msgType, Integer totalAmount, Integer totalSales) {
        this.goodsId = goodsId;
        this.gsType = gsType;
        this.consuType = consuType;
        this.goodsName = goodsName;
        this.purchasePrice = purchasePrice;
        this.moneyPrice = moneyPrice;
        this.goldPrice = goldPrice;
        this.rebateMoney = rebateMoney;
        this.state = state;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.coverImg = coverImg;
        this.classifys = classifys;
        this.bannerVideo = bannerVideo;
        this.goodsVideo = goodsVideo;
        this.goodsVideoImg = goodsVideoImg;
        this.goodsSpecImg = goodsSpecImg;
        this.coverImgDescription = coverImgDescription;
        this.coverImgDescription2 = coverImgDescription2;
        this.hideFlag = hideFlag;
        this.level = level;
        this.bigImg = bigImg;
        this.bannerImg = bannerImg;
        this.searchKeywords = searchKeywords;
        this.textDes = textDes;
        this.msgType = msgType;
        this.totalAmount = totalAmount;
        this.totalSales = totalSales;
    }

    /**
     * 商品主键
     */
    @Id
    private String goodsId;

    /**
     * 类型
     */
    private Integer gsType;

    /**
     * 消费类型
     */
    private Integer consuType;

    /**
     * 名称
     */
    private String goodsName;

    /**
     * 商品原价
     */
    private Long purchasePrice;

    /**
     * 商品金币购价格
     */
    private Long moneyPrice;

    /**
     * 商品金币购金币个数
     */
    private Long goldPrice;

    /**
     * 商品RMB 返利
     */
    private Long rebateMoney;

    /**
     * 状态（上架或下架）
     */
    private Integer state;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateAt;

    /**
     * 商品小图
     */
    private String coverImg;

    /**
     * 商品类型
     */
    private String classifys;

    /**
     * banner视频
     */
    private String bannerVideo;

    private String goodsVideo;

    private String goodsVideoImg;

    /**
     * 商品规格图片
     */
    private String goodsSpecImg;

    /**
     * 商品描述1
     */
    private String coverImgDescription;

    /**
     * 商品描述2
     */
    private String coverImgDescription2;

    /**
     * 商品隐藏
     */
    private Boolean hideFlag;

    /**
     * 商品优先级
     */
    private Integer level;

    /**
     * 商品大图
     */
    @Transient
    private String bigImg;

    @Transient
    private String bannerImg;

    /**
     * 搜索关键字
     */
    @Transient
    private String searchKeywords;

    /**
     * 商品详情
     */
    @Transient
    private String textDes;

    @Transient
    private Integer msgType;

    /**
     * 商品总库存  - 用于新手0元购
     */
    private Integer totalAmount;

    /**
     * 商品总销量  - 用于新手0元购
     */
    private Integer totalSales;

}
