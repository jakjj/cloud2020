package org.weizhen.seata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.weizhen.seata.service.StorageService;
import org.weizhen.springcloud.entities.CommonResult;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Resource
    StorageService storageService;


    @GetMapping(value = "/decrease")
    CommonResult<String> decrease (@RequestParam(value = "productId") Long productId
                                    , @RequestParam(value = "reduction") Integer reduction) {

        log.info("开始扣减库存");
        int decrease = storageService.decrease(productId, reduction);

        return new CommonResult<>(200,null, null);
    }
}
