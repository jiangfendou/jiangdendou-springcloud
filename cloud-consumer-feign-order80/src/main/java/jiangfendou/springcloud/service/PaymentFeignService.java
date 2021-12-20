package jiangfendou.springcloud.service;

import com.jiangfendou.springcloud.common.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @RequestMapping(value="payment/detail/{paymentId}", method = RequestMethod.GET)
    ApiResponse getPayment(@PathVariable(value="paymentId") String paymentId);

    @GetMapping(value = "payment/feign/timeout")
    String paymentFeignTimeout();
}
