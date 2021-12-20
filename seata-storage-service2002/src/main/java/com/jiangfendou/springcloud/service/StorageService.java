package com.jiangfendou.springcloud.service;


/**
 * StorageService.
 * @author jiangmh
 */
public interface StorageService {

    /**
     * 减库存
     * */
    void decrease(String productId, Integer count);
}
