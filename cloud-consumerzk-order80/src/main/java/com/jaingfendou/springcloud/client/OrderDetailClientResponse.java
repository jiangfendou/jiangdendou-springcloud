package com.jaingfendou.springcloud.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jiangfendou.springcloud.entities.payment.Payment;
import lombok.Data;

@Data
public class OrderDetailClientResponse {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("data")
    private Payment payment;
}
