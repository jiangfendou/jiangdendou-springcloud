package com.jiangfendou.springcloud.service;

import com.jiangfendou.springcloud.entities.payment.Payment;

public interface PaymentService {

    int creat(Payment payment);

    Payment getPaymentById(String id);
}
