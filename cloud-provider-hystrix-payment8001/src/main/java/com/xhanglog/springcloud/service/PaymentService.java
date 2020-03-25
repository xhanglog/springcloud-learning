package com.xhanglog.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author xhang
 * Date 2020/3/24
 **/
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池"+ Thread.currentThread().getName()+" paymentInfo_OK,id"+id+"\t"+"ok啊啊啊啊";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_timeout(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+ Thread.currentThread().getName()+" paymentInfo_timeout,id"+id+"\t"+"耗时："+time+"秒";
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池"+ Thread.currentThread().getName()+" paymentInfo_timeout,id"+id+"\t"+"o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_Fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//失败率到多少后跳闸

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("************id不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功"+serialNumber;
    }
    public String paymentCircuitBreaker_Fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试~~~       id："+id;
    }
}
