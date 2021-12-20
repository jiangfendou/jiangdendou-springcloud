package com.jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.client.OrderCreatClientResponse;
import com.jiangfendou.springcloud.client.OrderDetailClientResponse;
import com.jiangfendou.springcloud.common.ApiResponse;
import com.jiangfendou.springcloud.entities.payment.Payment;
import com.jiangfendou.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer/")
public class OrderController {

    @Value("${project.payment.url}")
    private String paymentCreatUrl;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "payment/creat", method = RequestMethod.POST)
    public ApiResponse creat (@RequestBody Payment payment) {
        OrderCreatClientResponse apiClientResponse = this.restTemplate.postForObject(paymentCreatUrl + "creat", payment, OrderCreatClientResponse.class);
        if (apiClientResponse.getData()) {
            return ApiResponse.success();
        }
        return ApiResponse.failed(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "payment/detail/{paymentId}", method = RequestMethod.GET)
    public ApiResponse getPayment (@PathVariable String paymentId) {
        OrderDetailClientResponse orderDetailClientResponse = this.restTemplate.getForObject(paymentCreatUrl + "detail/" + paymentId, OrderDetailClientResponse.class);
        return ApiResponse.success(orderDetailClientResponse.getPayment());
    }

}
