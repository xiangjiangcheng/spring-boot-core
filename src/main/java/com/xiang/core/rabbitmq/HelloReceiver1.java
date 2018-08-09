package com.xiang.core.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 消费者1
 *
 * <p>
 * Created by xiangjiangcheng on 2018/8/9 13:48.
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String sendMsg) {
        System.out.println("helloQueue-Receiver1  : " + sendMsg);
    }

}