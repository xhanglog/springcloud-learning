package com.xhanglog.spingcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author xhang
 * Date 2020/3/24
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "************PaymentFallbackService-paymentInfo_OK";
    }

    public String paymentInfo_timeout(Integer id) {
        return "************PaymentFallbackService-paymentInfo_timeout";
    }
}
