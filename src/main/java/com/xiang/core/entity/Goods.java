package com.xiang.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.Objects;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 17:00.
 */

@Data
@Entity
@Table(name = "goods")
public class Goods {
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

    private String coverImg;

    private String classifys;

    private String bannerVideo;

    private String goodsVideo;

    private String goodsVideoImg;

    private String goodsSpecImg;

    private String coverImgDescription;

    private String coverImgDescription2;

    private Boolean hideFlag;

    /**
     * 商品优先级
     */
    private Integer level;

    @Transient
    private String bigImg;

    @Transient
    private String bannerImg;

    @Transient
    private String searchKeywords;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) &&
                Objects.equals(gsType, goods.gsType) &&
                Objects.equals(consuType, goods.consuType) &&
                Objects.equals(goodsName, goods.goodsName) &&
                Objects.equals(purchasePrice, goods.purchasePrice) &&
                Objects.equals(moneyPrice, goods.moneyPrice) &&
                Objects.equals(goldPrice, goods.goldPrice) &&
                Objects.equals(rebateMoney, goods.rebateMoney) &&
                Objects.equals(state, goods.state) &&
                Objects.equals(createAt, goods.createAt) &&
                Objects.equals(updateAt, goods.updateAt) &&
                Objects.equals(coverImg, goods.coverImg) &&
                Objects.equals(classifys, goods.classifys) &&
                Objects.equals(bannerVideo, goods.bannerVideo) &&
                Objects.equals(goodsVideo, goods.goodsVideo) &&
                Objects.equals(goodsVideoImg, goods.goodsVideoImg) &&
                Objects.equals(goodsSpecImg, goods.goodsSpecImg) &&
                Objects.equals(coverImgDescription, goods.coverImgDescription) &&
                Objects.equals(coverImgDescription2, goods.coverImgDescription2) &&
                Objects.equals(hideFlag, goods.hideFlag) &&
                Objects.equals(level, goods.level) &&
                Objects.equals(bigImg, goods.bigImg) &&
                Objects.equals(bannerImg, goods.bannerImg) &&
                Objects.equals(searchKeywords, goods.searchKeywords) &&
                Objects.equals(textDes, goods.textDes) &&
                Objects.equals(msgType, goods.msgType) &&
                Objects.equals(totalAmount, goods.totalAmount) &&
                Objects.equals(totalSales, goods.totalSales);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), goodsId, gsType, consuType, goodsName, purchasePrice, moneyPrice, goldPrice, rebateMoney, state, createAt, updateAt, coverImg, classifys, bannerVideo, goodsVideo, goodsVideoImg, goodsSpecImg, coverImgDescription, coverImgDescription2, hideFlag, level, bigImg, bannerImg, searchKeywords, textDes, msgType, totalAmount, totalSales);
    }
}
