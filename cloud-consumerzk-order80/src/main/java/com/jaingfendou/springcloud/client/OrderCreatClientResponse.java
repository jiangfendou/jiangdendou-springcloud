package com.jaingfendou.springcloud.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class OrderCreatClientResponse implements Serializable {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("data")
    private Boolean data;
}
