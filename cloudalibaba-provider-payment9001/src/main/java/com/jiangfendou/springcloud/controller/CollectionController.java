package com.jiangfendou.springcloud.controller;

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

    @GetMapping("/nacos/{id}")
    public String getServerPort(@PathVariable ("id") String id){
        return serverPort + id;
    }
}