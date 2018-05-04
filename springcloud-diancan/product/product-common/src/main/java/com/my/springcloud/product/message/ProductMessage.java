package com.my.springcloud.product.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by liuyh on 2018/5/2
 */
public interface ProductMessage {
    String MESSAGE_TEST = "myMessage1";

//    @Output(ProductMessage.MESSAGE_TEST)
//    MessageChannel output();

}
