package com.my.springcloud.product.repository;

import com.my.springcloud.product.model.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lyh on 2018/4/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);

        Assert.assertTrue(productInfoList.size()>0);
    }

    @Test
    public void findByProductId() throws Exception{
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("adf1123ds2","adf12"));

        Assert.assertTrue(productInfoList.size()>0);
    }
}