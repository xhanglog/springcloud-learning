package com.xhanglog.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xhanglog.springcloud.entity.CommonResult;
import com.xhanglog.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xhang
 * Date 2020/4/1
 **/
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "byResource")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试",new Payment(2020L,"serial01"));
    }

    public CommonResult byResource(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按资源名称限流测试",new Payment(2020L,"serial01"));
    }

}
