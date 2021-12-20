package com.jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.common.ApiResponse;
import com.jiangfendou.springcloud.domain.Storage;
import com.jiangfendou.springcloud.service.StorageService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;


    @PostMapping("/decrease")
    public ApiResponse decrease(String productId, Integer count) {
        storageService.decrease(productId, count);
        return ApiResponse.success();
    }
}
