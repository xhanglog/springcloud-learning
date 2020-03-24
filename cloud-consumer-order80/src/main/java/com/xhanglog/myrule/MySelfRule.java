package com.xhanglog.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author xhang
 * Date 2020/3/23
 **/
@SpringBootConfiguration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule(); //规则定义为随机
    }
}
