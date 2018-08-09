package com.xiang.core.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 队列配置  初始化对应的队列
 *
 * <p>
 * Created by xiangjiangcheng on 2018/8/9 15:25.
 */

@Configuration
public class RabbitConfig {

    /**
     * 创建支付队列
     */
    @Bean
    public Queue payQueue() {
        return new Queue("payQueue");
    }

    /**
     * 创建Hello队列
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("helloQueue");
    }

}
