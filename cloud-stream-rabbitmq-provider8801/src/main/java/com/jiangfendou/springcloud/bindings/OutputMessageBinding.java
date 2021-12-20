package com.jiangfendou.springcloud.bindings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author jiangmh
 */
public interface OutputMessageBinding {

    /** Topic 名称*/
    String OUTPUT = "message-center";

    @Output(OUTPUT)
    MessageChannel output();
}
