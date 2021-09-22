package com.spacetim.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

/**
 * @author spacetim
 * @date 2021/8/26
 * @description
 */
public class Test {
    @Autowired
    private RedisTemplate redisTemplate;
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("47.96.150.59", 6379);
//        jedis.auth("1314520");

    }

    void testRedis(){


    }
}
