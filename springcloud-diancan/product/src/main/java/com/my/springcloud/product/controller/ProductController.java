package com.my.springcloud.product.controller;

import com.my.springcloud.product.model.ProductCategory;
import com.my.springcloud.product.model.ProductInfo;
import com.my.springcloud.product.services.CategoryService;
import com.my.springcloud.product.services.ProductService;
import com.my.springcloud.product.util.ResultVOUtil;
import com.my.springcloud.product.vo.ProductInfoVo;
import com.my.springcloud.product.vo.ProductVO;
import com.my.springcloud.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品
 * Created by lyh on 2018/4/19.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    /**
     *  1.查询所有在架的商品
     *  2.获取类目type的列表
     *  3.查询类目
     *  4.构造数据
     * @return
     */

    @GetMapping("/list")
    public ResultVO list(){

        // 查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //获取类目type列表
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

        //从数据库中查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCatgegoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){

                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);

                    productInfoVoList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);

            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表（给订单服务用的）
     * @param productList
     * @return
     */
    @GetMapping("/listForOrder")
    public List<ProductInfo> listForOrder(List<String> productList){
        return productService.findList(productList);
    }
}
