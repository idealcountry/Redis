package com.spacetim.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author spacetim
 * @date 2021/8/18
 * @description
 */
@Component
public class SenderA {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String context){
        System.out.println("SenderA: " + context);

        //使用AmqpTemplate将消息发送到队列中
        this.rabbitTemplate.convertAndSend("Queue1",context);
    }
}
