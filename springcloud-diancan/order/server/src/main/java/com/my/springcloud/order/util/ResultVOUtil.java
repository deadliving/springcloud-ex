package com.my.springcloud.order.util;


import com.my.springcloud.order.vo.ResultVO;

/**
 * Created by liuyh on 2018/4/23
 */
public class ResultVOUtil {

    public static ResultVO success(Object data){

        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;
    }

}
