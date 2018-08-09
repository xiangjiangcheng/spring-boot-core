package com.xiang.core.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 生产者1
 * rabbitTemplate是springboot 提供的默认实现
 *
 * <p>
 * Created by xiangjiangcheng on 2018/8/9 13:48.
 */
@Component
public class paySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String sendMsg) {
        String context = sendMsg + new Date();
        System.out.println("Sender1 : " + context);
        this.rabbitTemplate.convertAndSend("payQueue", context);
    }
}