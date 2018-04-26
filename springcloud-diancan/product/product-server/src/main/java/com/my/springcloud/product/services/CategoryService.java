package com.my.springcloud.product.services;

import com.my.springcloud.product.model.ProductCategory;

import java.util.List;

/**
 * Created by liuyh on 2018/4/23
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
