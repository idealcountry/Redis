package com.spacetim;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spacetim.entity.Person;
import com.spacetim.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author spacetim
 * @date 2021/8/27
 * @description
 */
@Slf4j
@SpringBootTest
public class RedisTest1 {

    @Autowired
    private RedisTemplate redisTemplate;

//  SpringBoot调用的测试注解包为：
//    import org.junit.jupiter.api.Test;
    @Test
    public void test1(){

      /*  User user = new User("狂神", 20);

        redisTemplate.opsForValue().set("name", user);
        System.out.println(redisTemplate.opsForValue().get("name"));*/
    }



    @Autowired
    private ObjectMapper objectMapper;

    //采用RedisTemplate将一对象信息序列化为Json格式字符串后写入缓存中，
    //然后将其读取出来，最后反序列化解析其中的内容并展示在控制台
    @Test
    public void two() throws Exception{
        log.info("------开始RedisTemplate操作组件实战----");

        //构造对象信息
        User user=new User(1,"debug","阿修罗");

        //Redis通用的操作组件
        ValueOperations valueOperations=redisTemplate.opsForValue();

        //将序列化后的信息写入缓存中
        String key="redis:template:two:object";
        final String content=objectMapper.writeValueAsString(user);
        valueOperations.set(key,content);

        key = "redis:template:three:object";
        valueOperations.set(key, user);


        log.info("写入缓存对象的信息：{} ",user);

        /*//从缓存中读取内容
        Object result=valueOperations.get(key);
        if (result!=null){
            User resultUser=objectMapper.readValue(result.toString(),User.class);
            log.info("读取缓存内容并反序列化后的结果：{} ",resultUser);
        }*/

        System.out.println(redisTemplate.opsForValue().get(key));
    }



    //列表类型
    @Test
    public void three() throws Exception{
        //构造已经排好序的用户对象列表
        List<Person> list=new ArrayList<>();
        list.add(new Person(1,21,"修罗", "debug", "火星"));
        list.add(new Person(2,22,"大圣","jack","水帘洞"));
        list.add(new Person(3,23,"盘古","Lee","上古"));
        log.info("构造已经排好序的用户对象列表: {} ",list);

        //将列表数据存储至Redis的List中
        final String key="redis:test:2";
        ListOperations listOperations=redisTemplate.opsForList();
        for (Person p:list){
            //往列表中添加数据-从队尾中添加
            listOperations.leftPush(key,p);
        }

        //获取Redis中List的数据-从队头中获取
        log.info("--获取Redis中List的数据-从队头中获取--");
        Object res=listOperations.rightPop(key);
        Person resP;
        while (res!=null){
            resP= (Person) res;
            log.info("当前数据：{} ",resP);
            res=listOperations.rightPop(key);
        }
    }



}
