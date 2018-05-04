package com.my.springcloud.order.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by liuyh on 2018/5/2
 */
public interface OrderMessage {
    String MESSAGE_ORDER = "myOrderQ";

    String MESSAGE_ORDER_RECEIVED = "orderReceived";
}
