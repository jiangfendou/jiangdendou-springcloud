package com.jiangfendou.springcloud.service.impl;

import com.jiangfendou.springcloud.dao.OrderDao;
import com.jiangfendou.springcloud.domain.Order;
import com.jiangfendou.springcloud.service.AccountService;
import com.jiangfendou.springcloud.service.OrderService;
import com.jiangfendou.springcloud.service.StorageService;
import com.jiangfendou.springcloud.util.StringUtils;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl.
 * @author jiangmh
 */
@Slf4j
@Service
@GlobalTransactional(name = "jiangfendou-order", rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderService orderService;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        order.setId(StringUtils.getUUID());
        log.info("-----------开始创建订单");
        orderDao.create(order);
        log.info("-----------订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----------订单微服务开始调用账户，做扣减");
        int num = 1/0;
        accountService.decrease(order.getUserId(), order.getMoney());
        // 修改订单的状态 从0 -> 1 代表订单已经完成
        log.info("------------修改订单状态开始");
        orderService.updateOrderStatus(order.getUserId(), 1);
        log.info("------------哈哈 欧里给");
    }

    @Override
    public void updateOrderStatus(String userId, Integer status) {
        orderDao.updateOrderStatus(userId, status);
    }
}
