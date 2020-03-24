package com.xhanglog.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author xhang
 * Date 2020/3/22
 **/
@RestController
@Slf4j
public class OrderZkController {

    @Resource
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public String getPaymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
