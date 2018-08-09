package com.xiang.core.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 消费者2
 *
 * <p>
 * Created by xiangjiangcheng on 2018/8/9 14:24.
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String sendMsg) {
        System.out.println("helloQueue-Receiver2  : " + sendMsg);
    }

}
