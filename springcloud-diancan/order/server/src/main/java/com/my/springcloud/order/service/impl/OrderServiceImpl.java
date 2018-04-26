package com.my.springcloud.order.service.impl;

import com.my.springcloud.client.ProductClient;
import com.my.springcloud.order.dto.OrderDto;
import com.my.springcloud.order.enums.OrderStatusEnum;
import com.my.springcloud.order.enums.PayStatusEnum;
import com.my.springcloud.order.model.OrderDetail;
import com.my.springcloud.order.model.OrderMaster;
import com.my.springcloud.order.repository.OrderDetailRepository;
import com.my.springcloud.order.repository.OrderMasterRepository;
import com.my.springcloud.order.service.OrderService;
import com.my.springcloud.order.util.KeyUtil;
import com.my.springcloud.product.dto.CartDto;
import com.my.springcloud.product.model.ProductInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liuyh on 2018/4/23
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDto create(OrderDto orderDto) {
        String orderId = KeyUtil.genUniqueKey();
        // 查询商品信息(调用商品服务)
        List<String > productIdList = orderDto.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail:orderDto.getOrderDetailList()){
            for(ProductInfo productInfo:productInfoList){
                if(orderDetail.getProductId().equals(productInfo.getProductId())){
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetail.setCreateTime(new Date());
                    orderDetail.setUpdateTime(new Date());
                    orderDetailRepository.save(orderDetail);
                    break;
                }
            }
        }
        //  扣库存(调用商品服务)

        List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream()
                .map(e -> new CartDto(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDtoList);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto, orderMaster);

        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        orderMasterRepository.save(orderMaster);
        return orderDto;
    }
}
