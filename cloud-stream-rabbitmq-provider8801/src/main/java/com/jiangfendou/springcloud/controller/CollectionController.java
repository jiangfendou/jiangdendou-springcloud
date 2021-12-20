package com.jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.service.CollectionService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangmh
 */
@RestController
public class CollectionController {

    @Resource
    private CollectionService collectionService;

    @GetMapping("/getCollection")
    public String sendMessage(String schoolName, String content){
        collectionService.getCollection(schoolName, content);
        return "success";
    }
}