package com.jiangfendou.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jiangfendou.springcloud.common.ApiResponse;

/**
 * @author jiangmh
 */
public class CustomerBlockHandler {

    public static ApiResponse handlerException(BlockException exception) {
        return ApiResponse.success("success，用户自定义,global-----1");
    }

    public static ApiResponse handlerException2(BlockException exception) {
        return ApiResponse.success("success，用户自定义,global-----2");
    }
}
