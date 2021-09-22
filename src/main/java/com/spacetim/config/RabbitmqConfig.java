package com.spacetim.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author spacetim
 * @date 2021/8/18
 * @description
 */
@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue queue(){
        return new Queue("Queue1");
    }
}
