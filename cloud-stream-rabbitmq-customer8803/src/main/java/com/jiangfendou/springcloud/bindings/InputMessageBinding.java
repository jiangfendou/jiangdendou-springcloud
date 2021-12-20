package com.jiangfendou.springcloud.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author jiangmh
 */
public interface InputMessageBinding {

    String INPUT = "message-center";

    @Input(INPUT)
    SubscribableChannel input();
}
