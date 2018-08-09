package com.xiang.core.controller;

import com.xiang.core.rabbitmq.HelloSender1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * RabbitMQ  消息队列 测试控制器
 * <p>
 * <p>
 * Created by xiangjiangcheng on 2018/8/9 13:49.
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTestController {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;

    @PostMapping("/hello")
    public void hello() {
        // 产生一个消息
        helloSender1.send("hello1");
    }

    /**
     * 单生产者-多消费者
     */
    @PostMapping("/oneToMany")
    public void oneToMany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hellomsg:" + i);
        }

    }

}
