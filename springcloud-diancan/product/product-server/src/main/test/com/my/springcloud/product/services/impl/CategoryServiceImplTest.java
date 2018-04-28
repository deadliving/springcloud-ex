package com.my.springcloud.product.services.impl;

import com.my.springcloud.product.ProductApplicationTests;
import com.my.springcloud.product.model.ProductCategory;
import com.my.springcloud.product.services.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyh on 2018/4/23
 */
@Component
public class CategoryServiceImplTest extends ProductApplicationTests{

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));

        Assert.assertTrue(byCategoryTypeIn.size()>0);
    }

}