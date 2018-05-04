package com.my.springcloud.product.message;

import com.my.springcloud.order.dto.OrderDto;
import com.my.springcloud.order.message.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


/**
 * Created by liuyh on 2018/4/28
 */
@Component
@EnableBinding({StreamClient.class})
public class StreamReceive {

    Logger logger = LoggerFactory.getLogger(StreamReceive.class);

//    @StreamListener(ProductMessage.MESSAGE_TEST)
    public void process(String message){
//        try {
//            InputStream in = new ByteArrayInputStream((byte[]) message);
//            BufferedReader reader = new BufferedReader(in);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        logger.info("StreamReceive: {}",message);
    }

    /**
     * 接受orderDto对象
     * @param orderDto
     */
    @StreamListener(OrderMessage.MESSAGE_ORDER)
    @SendTo(OrderMessage.MESSAGE_ORDER_RECEIVED)
    public String processOrder(OrderDto orderDto){
        logger.info("StreamReceive: {}",orderDto);
        return "received order:"+orderDto.getOrderId();
    }
}
