package com.jiangfendou.springcloud.controller;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
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
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/payment/nacos/{id}")
    public String  paymentInfo(@PathVariable("id") String id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }
}