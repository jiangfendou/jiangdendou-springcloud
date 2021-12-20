package com.jaingfendou.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-hystrix-service", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable(value="id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable(value="id") Integer id);
}
