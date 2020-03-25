package com.xhanglog.spingcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xhanglog.spingcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xhang
 * Date 2020/3/24
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentService paymentService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*
    就近原则，自己配置了就用自己的，没有配置就用全局的
    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    */
    @HystrixCommand
    public String paymentInfo_timeout(Integer id){
        return paymentService.paymentInfo_timeout(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，请10秒后重试或者自己系统出错检查自己，o(╥﹏╥)o";
    }

    /**
     * 全局fallback方法
     * @return
     */
    public String globalFallbackMethod(){
        return "全局降级处理，o(╥﹏╥)o";
    }
}
