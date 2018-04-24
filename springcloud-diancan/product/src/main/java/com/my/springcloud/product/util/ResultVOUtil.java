package com.my.springcloud.product.util;

import com.my.springcloud.product.vo.ResultVO;

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
