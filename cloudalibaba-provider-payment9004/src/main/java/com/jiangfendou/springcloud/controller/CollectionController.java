package com.jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.common.ApiResponse;
import com.jiangfendou.springcloud.entities.payment.Payment;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangmh
 */
@RestController
@RequestMapping(value = "/payment")
public class CollectionController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<String, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put("001", new Payment("str_001", "001"));
        hashMap.put("002", new Payment("str_002", "002"));
        hashMap.put("003", new Payment("str_003", "003"));
    }

    @GetMapping("/paymentSQL/{id}")
    public ApiResponse getServerPort(@PathVariable("id") String id){
        return ApiResponse.success(hashMap.get(id));
    }
}