package com.xhanglog.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhang
 * Date 2020/3/29
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String echo(@PathVariable Integer id) {
        return "Hello Nacos Discovery,serverport2： "+serverPort +"\t   id："+ id;
    }
}
