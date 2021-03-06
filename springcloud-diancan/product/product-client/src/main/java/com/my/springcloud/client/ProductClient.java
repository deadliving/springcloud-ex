package com.my.springcloud.client;

import com.my.springcloud.product.dto.CartDto;
import com.my.springcloud.product.model.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by liuyh on 2018/4/25
 */
@FeignClient(name="product")
@Component
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
     List<ProductInfo> listForOrder(List<String> productList);

    @PostMapping("/product/decreaseStock")
     void decreaseStock(@RequestBody List<CartDto> cartDtoList);
}
