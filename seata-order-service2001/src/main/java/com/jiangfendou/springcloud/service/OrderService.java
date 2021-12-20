package com.jiangfendou.springcloud.service;


import com.jiangfendou.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * OrderService.
 * @author jiangmh
 */
public interface OrderService {

    void create(Order order);

    /**
     *  修改订单状态
     */
    void updateOrderStatus(@Param("userId") String userId, @Param("status") Integer status);
}
