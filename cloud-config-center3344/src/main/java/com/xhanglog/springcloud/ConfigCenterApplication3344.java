package com.xhanglog.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author xhang
 * Date 2020/3/26
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterApplication3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication3344.class,args);
    }
}
