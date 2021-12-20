package com.jiangfendou.springcloud.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String id;

    private String userId;

    private String productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 0.创建中；1.已完结
     */
    private Integer status;
}
