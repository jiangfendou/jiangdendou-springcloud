package com.jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.common.ApiResponse;
import com.jiangfendou.springcloud.domain.Order;
import com.jiangfendou.springcloud.service.AccountService;
import com.jiangfendou.springcloud.service.OrderService;
import com.jiangfendou.springcloud.service.StorageService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;


    @PostMapping("/add")
    public ApiResponse create(Order order) {
        orderService.create(order);
        return ApiResponse.success();
    }
}
