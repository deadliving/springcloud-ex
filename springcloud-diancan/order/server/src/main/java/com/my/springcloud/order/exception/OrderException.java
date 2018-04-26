package com.my.springcloud.order.exception;


import com.my.springcloud.order.enums.ResultEnum;

/**
 * Created by liuyh on 2018/4/24
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
