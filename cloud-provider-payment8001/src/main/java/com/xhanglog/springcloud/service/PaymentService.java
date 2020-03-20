package com.xhanglog.springcloud.service;

import com.xhanglog.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author xhang
 * Date 2020/3/19
 **/
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
