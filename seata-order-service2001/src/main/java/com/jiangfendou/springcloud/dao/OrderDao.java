package com.jiangfendou.springcloud.dao;

import com.jiangfendou.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {

    /**
     *  创建订单
     */
    void create(Order order);

    /**
     *  修改订单状态
     */
    void updateOrderStatus(@Param("userId") String userId, @Param("status") Integer status);
}
