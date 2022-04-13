package org.weizhen.seata.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.weizhen.seata.service.OrderService;
import org.weizhen.springcloud.entities.CommonResult;
import org.weizhen.springcloud.entities.Order;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private OrderService orderService;


    @PostMapping("/create")
    public CommonResult create(@RequestBody Order order){
        int i = orderService.create(order);
        return new CommonResult(200, null);
    }

}

