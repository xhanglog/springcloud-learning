package com.xhanglog.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xhanglog.springcloud.entity.CommonResult;
import com.xhanglog.springcloud.entity.Payment;
import com.xhanglog.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author xhang
 * Date 2020/4/1
 **/
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//无其他配置
    //@SentinelResource(value = "fallback",fallback = "handlerfallback")//业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")//负责sentinel控制台违规配置
    @SentinelResource(value = "fallback",fallback = "handlerfallback",blockHandler = "blockHandler")
    public CommonResult<Payment> fallBack(@PathVariable("id") Long id){
        CommonResult<Payment> res = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException~~,非法参数异常");
        }else if(res.getData() == null){
            throw new NullPointerException("该ID没有记录");
        }
        return res;
    }

    //程序异常时返回，服务降级
    public CommonResult<Payment> handlerfallback(@PathVariable("id") Long id,Throwable throwable){
        Payment payment = new Payment(id, "null");
        return new CommonResult<Payment>(444,"异常返回，exception内容："+throwable.getMessage(),payment);
    }

    //sentinel配置的返回
    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException ex){
        Payment payment = new Payment(id, "null");
        return new CommonResult<Payment>(445,"sentinel限流："+ex.getMessage(),payment);
    }

    //------------------------------------
    @Resource
    private PaymentService paymentService;
    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
