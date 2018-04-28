package com.my.springcloud.order.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuyh on 2018/4/28
 */
@Component
@EnableBinding(StreamClient.class)
public class StreamReceive {

    Logger logger = LoggerFactory.getLogger(StreamReceive.class);

    @StreamListener(StreamClient.MESSAGE_INPUT)
    public void process(Object message){
        logger.info("StreamReceive: {}",message);
    }

}
