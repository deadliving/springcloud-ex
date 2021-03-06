package com.my.springcloud.order.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.my.springcloud.order.dto.OrderDto;
import com.my.springcloud.order.enums.ResultEnum;
import com.my.springcloud.order.exception.OrderException;
import com.my.springcloud.order.form.OrderForm;
import com.my.springcloud.order.model.OrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyh on 2018/4/24
 */
public class OrderForm2OrderDTOUtil {

    static Logger logger = LoggerFactory.getLogger(OrderForm2OrderDTOUtil.class);

    public static OrderDto convert(OrderForm orderForm){
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerPhone(orderForm.getPhone());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        Gson gson = new Gson();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (JsonSyntaxException e) {
            logger.error("【json转化】错误，string={}",orderForm.getItems());

            throw new OrderException(ResultEnum.PARAM_ERROR);
        }

        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }

}
