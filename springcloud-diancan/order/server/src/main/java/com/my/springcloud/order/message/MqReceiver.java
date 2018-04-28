package com.my.springcloud.order.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuyh on 2018/4/28
 */
@Component
public class MqReceiver {

    Logger logger = LoggerFactory.getLogger(MqReceiver.class);

//    @RabbitListener(queues = "myQueue")
//    自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")))
    public void process(String message){
        logger.info("MqReceiver : {}",message);
    }

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "computer",
            value = @Queue("computerOrder")
            ))
    public void process1(String message){
        logger.info("computer MqReceiver : {}",message);
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = "fruit",
            value = @Queue("fruitOrder")
            ))
    public void process2(String message){
        logger.info("fruit MqReceiver : {}",message);
    }

}
