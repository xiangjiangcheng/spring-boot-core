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
// 从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件
@Configuration
public class RabbitConfig {

    /**
     * 创建支付队列
     */
    // Bean标注在方法上(返回某个实例的方法)，等价于spring的xml配置文件中的<bean>，作用为：注册bean对象
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
