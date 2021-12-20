package com.jiangfendou.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentService {

    // ************************************服务降级

    public String paymentinfo_Ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_OK， id" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler", commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentinfo_Timeout(Integer id) {
        try {
            int timeNumber = 5;
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_Timeout， id" + id;
    }

    public String paymentinfo_TimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "抱歉系统繁忙请稍后再试" + id + "/(ㄒoㄒ)/~~";
    }

    // ************************************ 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
        // 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
        // 请求次数
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
        // 时间窗口期
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
        // 失败率达到多少后跳闸
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuiBreaker(@PathVariable("id") Integer id) {

        if (id < 0) {
           throw new RuntimeException("**************id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能复数，请稍后再试，/(ㄒoㄒ)/~~ * id：" + id;
    }
}
