package com.xhanglog.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xhang
 * Date 2020/3/19
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced  //开启负载均衡，在自己实现负载均衡的时候去掉这个注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
