package com.jiangfendou.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Storage.
 * @author jiangmh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private String id;

    private String productId;

    private Integer total;

    private Integer used;

    private Integer residue;

}
