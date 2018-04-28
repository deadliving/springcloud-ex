package com.my.springcloud.order.controller;

import com.my.springcloud.order.message.SendingBean;
import com.my.springcloud.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by liuyh on 2018/4/28
 */
@RestController
public class SendMessageController {

    @Autowired
    private SendingBean sendingBean;

    @GetMapping("/send")
    public void process(){
        String message = "now "+ new Date();
        sendingBean.sayHello(message);
    }

}
