package com.my.springcloud.order.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by liuyh on 2018/4/28
 */
@Component
public class SendingBean {
    private StreamClient streamClient;

    @Autowired
    public SendingBean(StreamClient streamClient) {
        this.streamClient = streamClient;
    }

    public void sayHello(String name) {
//        streamClient.output().send(MessageBuilder.withPayload(name).build());
    }
}
