package com.my.springcloud.product.services;

import com.my.springcloud.product.model.ProductInfo;
import com.my.springcloud.product.dto.CartDto;

import java.util.List;

/**
 * Created by liuyh on 2018/4/23
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);


    /**
     * 扣库存
     * @param cartDtoList
     */
    void  decreaseStock(List<CartDto> cartDtoList);
}
