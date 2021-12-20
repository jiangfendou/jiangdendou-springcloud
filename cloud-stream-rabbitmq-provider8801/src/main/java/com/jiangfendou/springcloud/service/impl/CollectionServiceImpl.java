package com.jiangfendou.springcloud.service.impl;

import com.jiangfendou.springcloud.bindings.OutputMessageBinding;
import com.jiangfendou.springcloud.entiy.CollectionRequest;
import com.jiangfendou.springcloud.service.CollectionService;
import javax.annotation.Resource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author jiangmh
 */
@Service
@EnableBinding(OutputMessageBinding.class)
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private OutputMessageBinding outputMessageBinding;

    /**
     * @param schoolName
     * @param content
     */
    @Override
    public void getCollection(String schoolName, String content) {

        CollectionRequest request = new CollectionRequest();
        request.setSchoolName(schoolName);
        request.setContent(content);

        outputMessageBinding.output().send(MessageBuilder.withPayload(request)
            .setHeader("x-delay", 5000).build());
    }
}
