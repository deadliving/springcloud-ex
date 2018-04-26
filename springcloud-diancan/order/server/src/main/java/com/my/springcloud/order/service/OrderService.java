package com.my.springcloud.order.service;


import com.my.springcloud.order.dto.OrderDto;

/**
 * Created by liuyh on 2018/4/23
 */
public interface OrderService {

    OrderDto create(OrderDto orderDto);

}
