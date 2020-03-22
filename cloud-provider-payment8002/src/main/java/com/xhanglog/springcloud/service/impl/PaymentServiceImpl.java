package com.xhanglog.springcloud.service.impl;

import com.xhanglog.springcloud.dao.PaymentDao;
import com.xhanglog.springcloud.entity.Payment;
import com.xhanglog.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author xhang
 * Date 2020/3/19
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
