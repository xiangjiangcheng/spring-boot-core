package com.xiang.core.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * pay 消费者
 *
 * <p>
 * Created by xiangjiangcheng on 2018/8/9 14:24.
 */
@Component
@RabbitListener(queues = "payQueue")
public class PayReceiver {

    @RabbitHandler
    public void process(String sendMsg) {
        System.out.println("PayReceiver  : " + sendMsg);
    }

}
