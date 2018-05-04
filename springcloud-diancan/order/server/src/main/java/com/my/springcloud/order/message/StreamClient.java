package com.my.springcloud.order.message;

import com.my.springcloud.product.message.ProductMessage;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by liuyh on 2018/4/28
 */
public interface StreamClient {

//    String MESSAGE_INPUT = "myInput";
//    String MESSAGE_OUTPUT = "myOutput";
//    String MESSAGE_TEST = "stream_test";

//    @Input(ProductMessage.MESSAGE_TEST)
//    SubscribableChannel input();

    @Input(OrderMessage.MESSAGE_ORDER_RECEIVED)
    SubscribableChannel input2();


//    String MESSAGE_ORDER = "myOrderQ";


    @Output(OrderMessage.MESSAGE_ORDER)
    MessageChannel output();


}
