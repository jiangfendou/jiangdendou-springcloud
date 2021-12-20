package com.jiangfendou.springcloud.service;

import com.jiangfendou.springcloud.common.ApiResponse;
import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * AccountService.
 * @author jiangmh
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    ApiResponse decrease(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);

}
