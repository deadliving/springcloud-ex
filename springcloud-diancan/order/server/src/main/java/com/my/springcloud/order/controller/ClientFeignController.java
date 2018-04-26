package com.my.springcloud.order.controller;

import com.my.springcloud.client.ProductClient;
import com.my.springcloud.product.dto.CartDto;
import com.my.springcloud.product.model.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyh on 2018/4/25
 */
@RestController
@Slf4j
public class ClientFeignController {

    @Autowired
    private ProductClient productClient;

    Logger logger = LoggerFactory.getLogger(ClientFeignController.class);

    @GetMapping("/getMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();

        logger.info("response = {}",response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> productInfos = productClient.listForOrder(Arrays.asList("adf1123ds2", "adf12"));

        logger.info("response={}",productInfos);

        return "success";
    }

    @GetMapping("/decreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDto("adf1123ds2",3)));
        return "ok";
    }
}
