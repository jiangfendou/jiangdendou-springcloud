package com.jiangfendou.springcloud.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment/")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/consul", method = RequestMethod.GET)
    public String paymentConsul() {
        System.out.println("++++++++++++++++++++++++");
        return "springcloud width consul:" + serverPort + "\t" + UUID.randomUUID().toString().replace("-", "");
    }
}
