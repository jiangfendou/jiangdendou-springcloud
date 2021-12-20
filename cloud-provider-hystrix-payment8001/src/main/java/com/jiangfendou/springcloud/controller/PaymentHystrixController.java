package com.jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentHystrixController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable(value="id") Integer id) {
        String result = paymentService.paymentinfo_Ok(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable(value="id") Integer id) {
        String result = paymentService.paymentinfo_Timeout(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable(value="id") Integer id) {
        String result = paymentService.paymentCircuiBreaker(id);
        log.info("result:" + result);
        return result;
    }

}
