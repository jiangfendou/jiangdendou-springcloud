package com.jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.common.ApiResponse;
import com.jiangfendou.springcloud.entities.payment.Payment;
import com.jiangfendou.springcloud.service.PaymentService;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableDiscoveryClient
@RequestMapping(value = "/payment/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/creat", method = RequestMethod.POST)
    public ApiResponse creat(@RequestBody Payment payment) {
        System.out.println("server.port:" + serverPort);
        int result = this.paymentService.creat(payment);
        return ApiResponse.success(result);

    }

    @RequestMapping(value = "/detail/{paymentId}", method = RequestMethod.GET)
    public ApiResponse getPayment(@PathVariable String paymentId) {
        System.out.println("server.port:" + serverPort);
        Payment payment = this.paymentService.getPaymentById(paymentId);
        return ApiResponse.success(payment);

    }

    @RequestMapping(value = "/lb", method = RequestMethod.GET)
    public String getLb() {
        return serverPort;

    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("element:" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance serviceInstance : instances) {
            System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t"
                + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
