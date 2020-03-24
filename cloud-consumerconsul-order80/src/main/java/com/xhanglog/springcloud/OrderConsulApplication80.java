package com.xhanglog.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author xhang
 * Date 2020/3/22
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulApplication80.class,args);
    }
}
