package com.xhanglog.springcloud.service;

import com.xhanglog.springcloud.entity.CommonResult;
import com.xhanglog.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author xhang
 * Date 2020/4/1
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444,"服务降级返回，-------PaymentFallbackService");
    }
}
