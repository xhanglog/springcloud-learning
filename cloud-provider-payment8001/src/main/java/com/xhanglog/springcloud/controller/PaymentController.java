package com.xhanglog.springcloud.controller;

import com.xhanglog.springcloud.entity.CommonResult;
import com.xhanglog.springcloud.entity.Payment;
import com.xhanglog.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author xhang
 * Date 2020/3/19
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.create(payment);
        log.info("-----------------插入结果：" + res);
        if (res > 0){
            return new CommonResult(200,"插入成功", res);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("-----------------查询结果：" + payment);
        if (payment != null){
            return new CommonResult(200,"查询成功", payment);
        }else {
            return new CommonResult(444,"查询失败，id为："+id);
        }
    }

}
