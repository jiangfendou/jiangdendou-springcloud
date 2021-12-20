package com.jiangfendou.springcloud.service.impl;

import com.jiangfendou.springcloud.dao.StorageDao;
import com.jiangfendou.springcloud.service.StorageService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl.
 * @author jiangmh
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(String productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
