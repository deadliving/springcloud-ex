package com.example.order.repository;

import com.example.order.model.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuyh on 2018/4/23
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

}
