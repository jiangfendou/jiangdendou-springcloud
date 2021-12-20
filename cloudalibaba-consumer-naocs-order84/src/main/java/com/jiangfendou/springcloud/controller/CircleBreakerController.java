package com.jiangfendou.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.jiangfendou.springcloud.common.ApiResponse;
import com.jiangfendou.springcloud.entities.payment.Payment;
import com.jiangfendou.springcloud.service.PaymentService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jiangmh
 */
@RestController
@RequestMapping(value = "/consumer")
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    private static final String SERVICE_URL = "http://nacos-payment-provider";

    @GetMapping(value = "/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback")
    public ApiResponse fallback(@PathVariable("id") String id) throws IllegalAccessException {
        ApiResponse forObject = restTemplate.getForObject(SERVICE_URL + "/payment/paymentSQL/" + id, ApiResponse.class);
        if ("4".equals(id)) {
            throw new IllegalAccessException("非法参数异常");
        } else if(forObject.getData() == null ) {
            throw new NullPointerException("该Id没有对应的记录");
        }
        return forObject;
    }

    public ApiResponse handlerFallback(@PathVariable String id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return ApiResponse.failed(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/paymentSQL/{id}")
    public ApiResponse paymentSQL(@PathVariable("id") String id) {
        return paymentService.paymentSQL(id);
    }
}