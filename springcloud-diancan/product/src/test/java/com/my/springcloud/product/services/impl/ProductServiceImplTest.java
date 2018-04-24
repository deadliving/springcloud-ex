package com.my.springcloud.product.services.impl;

import com.my.springcloud.product.ProductApplicationTests;
import com.my.springcloud.product.model.ProductInfo;
import com.my.springcloud.product.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by liuyh on 2018/4/23
 */

@Component
public class ProductServiceImplTest extends ProductApplicationTests{

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {

        List<ProductInfo> upAll = productService.findUpAll();

        Assert.assertTrue(upAll.size()>0);
    }

}