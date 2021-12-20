package jiangfendou.springcloud.controller;

import com.jiangfendou.springcloud.common.ApiResponse;
import jiangfendou.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/consumer/")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;



    @RequestMapping(value = "payment/detail/{paymentId}", method = RequestMethod.GET)
    public ApiResponse getPayment (@PathVariable String paymentId) {
        return paymentFeignService.getPayment(paymentId);
    }

    @GetMapping(value = "payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
