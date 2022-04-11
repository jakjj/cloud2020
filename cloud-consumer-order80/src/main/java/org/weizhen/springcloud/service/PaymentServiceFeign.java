package org.weizhen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.weizhen.springcloud.entities.CommonResult;
import org.weizhen.springcloud.entities.Payment;

@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
@Component
public interface PaymentServiceFeign {

    @PostMapping("/payment/info")
    CommonResult<Integer> addInfo(Payment payment);

    @GetMapping("/payment/info/{id}")
    CommonResult<Payment> getInfo(@PathVariable(value = "id") Long id);
}
