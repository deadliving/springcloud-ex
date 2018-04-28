package com.my.springcloud.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by liuyh on 2018/4/28
 */
@Component
public class MqSendTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue","now:"+new Date());
    }
    @Test
    public void send1(){
        amqpTemplate.convertAndSend("myOrder","computer","now:"+new Date());
    }
}
