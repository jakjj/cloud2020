package org.weizhen.springcloud.controller;

import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.weizhen.springcloud.entities.CommonResult;
import org.weizhen.springcloud.entities.Payment;
import org.weizhen.springcloud.service.PaymentServiceFeign;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    PaymentServiceFeign paymentServiceFeign;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "create/info", payment, CommonResult.class);
    }

    @RequestMapping("/payment/info/{id}")
    public CommonResult<Payment> getInfo(@PathVariable("id") Long id){
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/info/" + id, CommonResult.class);
        return paymentServiceFeign.getInfo(id);
    }
}
