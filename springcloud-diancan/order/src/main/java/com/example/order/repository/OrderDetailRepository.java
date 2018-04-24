package com.example.order.repository;

import com.example.order.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuyh on 2018/4/23
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
}
