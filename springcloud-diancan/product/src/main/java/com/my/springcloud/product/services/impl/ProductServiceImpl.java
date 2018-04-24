package com.my.springcloud.product.services.impl;

import com.my.springcloud.product.enums.ProductStatusEnum;
import com.my.springcloud.product.model.ProductInfo;
import com.my.springcloud.product.repository.ProductInfoRepository;
import com.my.springcloud.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuyh on 2018/4/23
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
