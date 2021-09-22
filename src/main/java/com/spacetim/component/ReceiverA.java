package com.spacetim.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author spacetim
 * @date 2021/8/18
 * @description
 */
@Component
@RabbitListener(queues = "Queue1")
public class ReceiverA {
    @RabbitHandler
    public void QueueReceiver(String Queue1){
        System.out.println("ReceiverA: " + Queue1);
    }
}
