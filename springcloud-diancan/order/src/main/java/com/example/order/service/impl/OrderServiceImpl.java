package com.example.order.service.impl;

import com.example.order.dto.OrderDto;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import com.example.order.model.OrderMaster;
import com.example.order.repository.OrderDetailRepository;
import com.example.order.repository.OrderMasterRepository;
import com.example.order.service.OrderService;
import com.example.order.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liuyh on 2018/4/23
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDto create(OrderDto orderDto) {
        //todo 查询商品信息(调用商品服务)

        //todo 计算总价

        // todo 扣库存(调用商品服务)

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDto, orderMaster);

        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        orderMasterRepository.save(orderMaster);
        return orderDto;
    }
}
