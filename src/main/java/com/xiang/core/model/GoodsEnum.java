package com.xiang.core.model;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 商品
 * <p>
 * Created by xiangjiangcheng on 2018/6/27 17:03.
 */
public enum GoodsEnum {
    /**
     * RMB商品
     */
    RMB_GOODS("人民币商品", 1),
    /**
     * 金币购商品
     */
    GOLD_GOODS("金币购商品", 2),

    /**
     * 新用户0元购商品
     */
    NEW_USER_GOODS("新用户0元购商品", 3),

    /**
     * 出售
     */
    ON_LINE("商品出售", 1),

    /**
     * 停售
     */
    OFF_GOODS("商品停售", 2);

    // 成员变量
    private String name;
    private int value;

    GoodsEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
