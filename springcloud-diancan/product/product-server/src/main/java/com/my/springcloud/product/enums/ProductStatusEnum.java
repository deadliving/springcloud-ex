package com.my.springcloud.product.enums;

/**
 * 商品上下架状态
 *
 * Created by liuyh on 2018/4/23
 */
public enum  ProductStatusEnum {
    UP(0,"在架"),DOWN(1,"下架"),;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
