package com.jiangfendou.springcloud.service;

import com.jiangfendou.springcloud.common.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author jiangmh
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/payment/paymentSQL/{id}")
    public ApiResponse paymentSQL(@PathVariable("id") String id);
}
