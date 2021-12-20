package com.jaingfendou.springcloud.controller;

import com.jaingfendou.springcloud.service.PaymentFeignService;
import com.jiangfendou.springcloud.common.ApiResponse;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@RequestMapping("/consumer/")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/payment/hystrix/ok/{id}", method = RequestMethod.GET)
    public String paymentInfo_OK (@PathVariable Integer id) {
        return paymentFeignService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler", commandProperties = {
//        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentinfo_Timeout(Integer id) {
        String result = paymentFeignService.paymentInfo_Timeout(id);
        log.info("result:" + result);
        return result;
    }

    public String paymentinfo_TimeoutHandler(Integer id) {
        return "我是消费者80,对方支付系统繁忙10秒钟后再试或者自己运行时出错请检查自己！/(ㄒoㄒ)/~~";
    }

    // 下面时全局的fallback方法
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息，请稍后再试！/(ㄒoㄒ)/~~";
    }

}
