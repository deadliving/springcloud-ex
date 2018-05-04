package com.my.springcloud.product.message;

import com.my.springcloud.order.message.OrderMessage;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by liuyh on 2018/5/3
 */
public interface StreamClient {


    @Input(OrderMessage.MESSAGE_ORDER)
    SubscribableChannel input();

}
