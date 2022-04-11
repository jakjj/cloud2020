package org.weizhen.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.weizhen.springcloud.service.PaymentService;
import org.weizhen.springcloud.entities.CommonResult;
import org.weizhen.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    String port;

    static List<String> messageList = new ArrayList<>();

    @PostMapping("/info")
    public CommonResult<Boolean> addInfo(@RequestBody Payment payment){

        int i = paymentService.addInfo(payment);
        log.info("插入结果：" + i);

        if(i>0){
            return new CommonResult<>(200,"插入成功",null);
        }else{
            return new CommonResult<>(500,"插入失败",null);
        }
    }

    @GetMapping("/info/{id}")
    public CommonResult<Payment> getInfo(@PathVariable(value = "id") Long id){

        String format = String.format("执行查找操作，当前端口号：%s, 执行id：%s\n", port, UUID.randomUUID().toString());

        log.info(String.format("执行查找操作，当前端口号：%s, 执行id：%s\n", port, id));
        return new CommonResult<Payment>(200, null,paymentService.getInfoById(id));
    }
}
