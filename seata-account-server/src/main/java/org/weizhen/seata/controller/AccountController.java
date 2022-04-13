package org.weizhen.seata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.weizhen.seata.service.AccountService;
import org.weizhen.springcloud.entities.CommonResult;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping(value = "/decrease")
    CommonResult<String> decrease (@RequestParam(value = "productId") Long productId
            , @RequestParam(value = "reduction") BigDecimal reduction) {

        log.info("开始扣减钱");
        int decrease = accountService.decrease(productId, reduction);

        return new CommonResult<>(200,null, null);
    }
    
}
