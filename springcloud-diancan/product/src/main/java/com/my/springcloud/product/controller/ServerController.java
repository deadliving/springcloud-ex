package com.my.springcloud.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyh on 2018/4/24
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product msg";
    }

}
