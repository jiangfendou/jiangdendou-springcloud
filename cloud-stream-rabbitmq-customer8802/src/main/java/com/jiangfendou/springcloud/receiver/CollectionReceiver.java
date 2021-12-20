package com.jiangfendou.springcloud.receiver;

import com.alibaba.fastjson.JSON;
import com.jiangfendou.springcloud.bindings.InputMessageBinding;
import com.jiangfendou.springcloud.entiy.CollectionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author jiangmh
 */
@Slf4j
@EnableBinding(InputMessageBinding.class)
public class CollectionReceiver {

    @StreamListener(InputMessageBinding.INPUT)
    public void handle(String value){
        log.info("[消息] 接收到发送消息MQ: {}", value);
        CollectionRequest request = JSON.parseObject(value, CollectionRequest.class);
        log.info("处理收集信息：" + request.toString());
    }
}
