package com.my.springcloud.product.vo;

import lombok.Data;

/**
 *  http请求返回的最外层的对象
 * Created by liuyh on 2018/4/23
 */
@Data
public class ResultVO<T> {

    /**
     * 错误吗
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体对象
     */
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
