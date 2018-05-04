package com.my.springcloud.product.controller;

import com.my.springcloud.product.message.SendingBean;
import org.springframework.beans.factory.annotation.Autowired;
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
