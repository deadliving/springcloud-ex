package com.my.springcloud.product.services;

import com.my.springcloud.product.model.ProductInfo;

import java.util.List;

/**
 * Created by liuyh on 2018/4/23
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

}
