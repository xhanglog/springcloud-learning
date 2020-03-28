package com.xhanglog.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author xhang
 * Date 2020/3/28
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamMQApplication8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQApplication8802.class,args);
    }
}
