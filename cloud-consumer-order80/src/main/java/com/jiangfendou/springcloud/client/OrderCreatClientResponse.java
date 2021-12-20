package com.jiangfendou.springcloud.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderCreatClientResponse implements Serializable {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("data")
    private Boolean data;
}
