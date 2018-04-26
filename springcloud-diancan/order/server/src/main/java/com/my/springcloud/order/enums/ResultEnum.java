package com.my.springcloud.order.enums;

/**
 * Created by liuyh on 2018/4/24
 */
public enum  ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
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
