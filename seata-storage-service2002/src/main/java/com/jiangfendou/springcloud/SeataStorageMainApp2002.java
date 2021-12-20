package com.jiangfendou.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jiangmh
 */
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan({"com.jiangfendou.springcloud.dao"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源的自动创建
public class SeataStorageMainApp2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMainApp2002.class,args);
    }
}
