package com.xhanglog.springcloud.controller;

import com.xhanglog.springcloud.entity.CommonResult;
import com.xhanglog.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author xhang
 * Date 2020/3/29
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    //模拟数据库数据
    public static HashMap<Long, Payment> hashMap = new HashMap<Long, Payment>();
    static {
        hashMap.put(1L,new Payment(1L,"11111111111111111111111111111111"));
        hashMap.put(2L,new Payment(2L,"22222222222222222222222222222222"));
        hashMap.put(3L,new Payment(3L,"33333333333333333333333333333333"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        return new CommonResult<Payment>(200," from server："+serverPort,payment);
    }
}
