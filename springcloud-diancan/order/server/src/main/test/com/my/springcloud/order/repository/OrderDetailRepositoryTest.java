package com.my.springcloud.order.repository;

import com.my.springcloud.order.OrderApplicationTests;
import com.my.springcloud.order.model.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by liuyh on 2018/4/23
 */
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("143422");
        orderDetail.setOrderId("d12dfa");
        orderDetail.setProductIcon("http://adsfj.com");
        orderDetail.setProductId("adf1123ds2");
        orderDetail.setProductPrice(new BigDecimal(12.0));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductName("蜜汁鸡翅");


        OrderDetail result = orderDetailRepository.save(orderDetail);

        Assert.assertTrue(result != null);
    }

}