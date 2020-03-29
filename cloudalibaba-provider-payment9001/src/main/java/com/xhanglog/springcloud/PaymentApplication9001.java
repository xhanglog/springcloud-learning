package com.xhanglog.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author xhang
 * Date 2020/3/29
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9001.class, args);
    }
}
