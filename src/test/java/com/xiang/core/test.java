package com.xiang.core;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Created by xiangjiangcheng on 2018/7/16 13:50.
 */
public class test {
    public static void main(String[] args) {

//        14455 / 100 / 100 = 1.4455 yuan
        // Double 转 Long
        Double dddd = 144.55d;

        System.out.println(dddd.longValue());

        String[] taskMsgArr = "ssdfasd".split("_");
        String queueType = taskMsgArr[0];
    }
}
