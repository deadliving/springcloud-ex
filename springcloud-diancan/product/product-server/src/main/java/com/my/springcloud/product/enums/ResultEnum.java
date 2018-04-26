package com.my.springcloud.product.enums;

/**
 * Created by liuyh on 2018/4/24
 */
public enum ResultEnum {

    STOCK_NOT_ENOUGH(1,"库存不足"),
    ITEM_NOT_EXIST(2,"商品不存在")
    ;

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
