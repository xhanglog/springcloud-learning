package com.xhanglog.springcloud;

import com.xhanglog.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author xhang
 * Date 2020/3/19
 **/
@SpringBootApplication
@EnableEurekaClient
//该注解用于指定负载规则
//@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication80.class);
    }
}
