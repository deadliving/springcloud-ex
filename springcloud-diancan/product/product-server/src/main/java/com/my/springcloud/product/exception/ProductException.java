package com.my.springcloud.product.exception;

import com.my.springcloud.product.enums.ResultEnum;

/**
 * Created by liuyh on 2018/4/26
 */
public class ProductException extends RuntimeException{

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
