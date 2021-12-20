package com.jiangfendou.springcloud.dao;

import com.jiangfendou.springcloud.entities.payment.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int creat(@Param("payment") Payment payment);

    Payment getPaymentById(@Param("id") String id);

}
