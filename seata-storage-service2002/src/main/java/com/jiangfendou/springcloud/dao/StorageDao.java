package com.jiangfendou.springcloud.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author jiangmh
 */
public interface StorageDao {

    /**
     * 减库存
     * */
    void decrease(@Param("productId") String productId, @Param("count") Integer count);
}
