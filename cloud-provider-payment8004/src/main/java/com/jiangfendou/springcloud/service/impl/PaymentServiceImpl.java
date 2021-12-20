package com.jiangfendou.springcloud.service.impl;

import com.jiangfendou.springcloud.common.ApiError;
import com.jiangfendou.springcloud.common.PaymentException;
import com.jiangfendou.springcloud.dao.PaymentDao;
import com.jiangfendou.springcloud.entities.payment.Payment;
import com.jiangfendou.springcloud.service.PaymentService;
import com.jiangfendou.springcloud.type.ErrorCode;
import com.jiangfendou.springcloud.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int creat(Payment payment) {
        String paymentId = StringUtils.getUUID();
        payment.setId(paymentId);
        int count = this.paymentDao.creat(payment);
        if (count > 0) {
            log.info("********插入结果：" + count);
            return count;
        }
        throw new PaymentException(HttpStatus.BAD_REQUEST, new ApiError(ErrorCode.CREAT_ERROR.getCode(), ErrorCode.CREAT_ERROR.getMessage()));
    }

    @Override
    public Payment getPaymentById(String id) {
        Payment payment = this.paymentDao.getPaymentById(id);
        if (payment == null) {
            log.info("********目标数据没有被找到：" + id);
            throw new PaymentException(HttpStatus.NOT_FOUND, new ApiError(ErrorCode.NOT_FOUND.getCode(), ErrorCode.NOT_FOUND.getMessage()));
        }
        return payment;
    }
}
