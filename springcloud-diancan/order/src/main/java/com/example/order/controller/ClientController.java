package com.example.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liuyh on 2018/4/24
 */
@RestController
public class ClientController {

    Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //第一种方式，直接使用restTemplate，url写死
        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:9200/msg",String.class);

        //第二种方式，利用loadBalancerClient通过应用名获取url，然后再使用restTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
        String response = restTemplate.getForObject(url,String.class);

        //第三种方式
//        String response = restTemplate.getForObject("http://product/msg",String.class);

        logger.info("response = {}",response);
        return response;
    }

}
