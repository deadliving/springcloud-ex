package com.my.springcloud.product.services.impl;

import com.alibaba.fastjson.JSON;
import com.my.springcloud.product.enums.ProductStatusEnum;
import com.my.springcloud.product.enums.ResultEnum;
import com.my.springcloud.product.exception.ProductException;
import com.my.springcloud.product.model.ProductInfo;
import com.my.springcloud.product.repository.ProductInfoRepository;
import com.my.springcloud.product.services.ProductService;
import com.my.springcloud.product.dto.CartDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by liuyh on 2018/4/23
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<CartDto> cartDtoList) {
        for(CartDto cartDto:cartDtoList){
//            ProductInfo productInfo = productInfoRepository.getOne(cartDto.getProductId());
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDto.getProductId());
            //判断商品是否存在
            if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.ITEM_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDto.getProductQunantity();
            //判断库存是否足够
            if(result<0){
                throw new ProductException(ResultEnum.STOCK_NOT_ENOUGH);
            }
            productInfo.setProductStock(result);
            productInfo.setUpdateTime(new Date());

            productInfoRepository.save(productInfo);

            //发送mq消息
            amqpTemplate.convertAndSend("productInfo", JSON.toJSON(productInfo));
        }
    }
}
