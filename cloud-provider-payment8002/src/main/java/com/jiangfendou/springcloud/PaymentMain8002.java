package com.jiangfendou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/**
 * 或者用@EnableDiscoveryClient  从Spring Cloud Edgware开始两者可以省略
 * 共同点是让注册中心发现该服务
 * 不同点是
 *  @EnableEurekaClient：只能有用于Eureka注册中心
 *  @EnableDiscoveryClient：可以用于其他注册中心
 * */
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class, args);
    }
}
