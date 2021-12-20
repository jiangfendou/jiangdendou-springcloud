package com.jaingfendou.springcloud.controller;

import com.jiangfendou.springcloud.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer/")
public class OrderController {

    @Value("${project.payment.url}")
    private String paymentCreatUrl;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "payment/zk", method = RequestMethod.GET)
    public ApiResponse getZk() {
        String result = this.restTemplate.getForObject(paymentCreatUrl, String.class);
        return ApiResponse.success(result);
    }
}
