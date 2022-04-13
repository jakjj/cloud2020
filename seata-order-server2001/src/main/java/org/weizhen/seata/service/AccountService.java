package org.weizhen.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.weizhen.springcloud.entities.CommonResult;

import java.math.BigDecimal;

@FeignClient("seata-account-server")
public interface AccountService {

    @GetMapping(value = "/account/decrease")
    CommonResult<String> decrease (@RequestParam(value = "productId") Long productId
                                , @RequestParam(value = "reduction") BigDecimal reduction);
}
