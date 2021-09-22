package com.spacetim;


import com.spacetim.component.SenderA;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Date;
@Slf4j
@SpringBootTest
class RedisTestApplicationTests {
//    根据类型匹配寻找对应的Bean
//    依赖注入
    @Autowired
    private RedisTemplate redisTemplate = null;
    @Autowired
    private SenderA senderA;
    @Test
    void contextLoads() {
    }



    //采用RedisTemplate将一字符串信息写入缓存中，并读取出来
    @Test
    public void one(){
        log.info("------开始RedisTemplate操作组件实战----");

        //定义字符串内容以及存入缓存的key
        final String content="RedisTemplate实战字符串信息";
        final String key="redis:template:one:string";

        //Redis通用的操作组件
        ValueOperations valueOperations=redisTemplate.opsForValue();

        //将字符串信息写入缓存中
        log.info("写入缓存中的内容：{} ",content);
        valueOperations.set(key,content);

        //从缓存中读取内容
        Object result=valueOperations.get(key);
        log.info("读取出来的内容：{} ",result);
    }








    @Test
    void test1(){

        // 需要使用redis-cli --raw的命令可以解决乱码的情况
        // keys*: \xac\xed\x00\x05t\x00\x04key2
        redisTemplate.opsForValue().set("key2", "你很帅喔");
        System.out.println(redisTemplate.opsForValue().get("key1"));

    }

    @Value("${age}")
    private int age;
    @Test
    void test2(){

        System.out.println(age);
    }

    @Test
    void QueueSend(){
        int i = 2;
        for(int j = 0;j < i;j++){
            String msg = "Queue1 msg" + j + new Date();
            try {
                senderA.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void test3(){
        Jedis jedis = new Jedis("47.96.150.59", 6379);
        jedis.auth("1314520");
        System.out.println(jedis.ping());
    }
}
