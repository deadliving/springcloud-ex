package com.my.springcloud.order.message;

import com.my.springcloud.order.dto.OrderDto;
import com.my.springcloud.product.message.ProductMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuyh on 2018/4/28
 */
@Component
@EnableBinding({StreamClient.class})
public class StreamReceive {

    Logger logger = LoggerFactory.getLogger(StreamReceive.class);

//    @StreamListener(ProductMessage.MESSAGE_TEST)
//    public void process1(String message){
//        logger.info("StreamReceive: {}",message);
//    }

    /**
     * 接受orderDto对象
     * @param orderDto
     */
//    @StreamListener(StreamClient.MESSAGE_ORDER)
    public void process(OrderDto orderDto){
        logger.info("StreamReceive: {}",orderDto);
    }


    @StreamListener(OrderMessage.MESSAGE_ORDER_RECEIVED)
    public void receiveOrder(String message){
        logger.info("StreamReceive2 {}",message);
    }
}
