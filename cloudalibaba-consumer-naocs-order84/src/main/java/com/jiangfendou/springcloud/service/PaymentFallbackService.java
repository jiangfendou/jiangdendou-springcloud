package com.jiangfendou.springcloud.service;

import com.jiangfendou.springcloud.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public ApiResponse paymentSQL(String id) {
        return ApiResponse.failed(HttpStatus.NOT_ACCEPTABLE);
    }
}
