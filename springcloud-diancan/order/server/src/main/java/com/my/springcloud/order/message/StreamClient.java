package com.my.springcloud.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by liuyh on 2018/4/28
 */
public interface StreamClient {

    String MESSAGE_INPUT = "myInput";
    String MESSAGE_OUTPUT = "myOutput";

    @Input(MESSAGE_INPUT)
    SubscribableChannel input();

    @Output(MESSAGE_OUTPUT)
    MessageChannel output();

}
