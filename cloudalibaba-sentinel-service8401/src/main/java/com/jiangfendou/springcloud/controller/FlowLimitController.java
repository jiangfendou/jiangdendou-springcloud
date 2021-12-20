package com.jiangfendou.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiangfendou.springcloud.common.ApiResponse;
import com.jiangfendou.springcloud.myhandler.CustomerBlockHandler;
import java.util.concurrent.TimeUnit;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangmh
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "-----testB";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("测试TestD");
        return "-----testD";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public ApiResponse byResource() {

        return ApiResponse.success("success");
    }

    public ApiResponse handleException(BlockException blockException) {

        return ApiResponse.failed(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public ApiResponse byUrl() {
        return ApiResponse.success("success");
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
        blockHandlerClass = CustomerBlockHandler.class,
        blockHandler = "handlerException2")
    public ApiResponse customerBlockHandler() {
        return ApiResponse.success("success，用户自定义");
    }

}
