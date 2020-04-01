package com.xhanglog.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author xhang
 * Date 2020/3/30
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceApplication8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication8401.class,args);
    }
}
