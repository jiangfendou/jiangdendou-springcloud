package com.jiangfendou.springcloud.service;

import com.jiangfendou.springcloud.common.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * StorageService.
 * @author jiangmh
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    ApiResponse decrease(@RequestParam("productId") String productId, @RequestParam("count") Integer count);
}
