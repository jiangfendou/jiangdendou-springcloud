package com.jaingfendou.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentFeignService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_Ok, /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_Timeout, /(ㄒoㄒ)/~~";
    }
}
