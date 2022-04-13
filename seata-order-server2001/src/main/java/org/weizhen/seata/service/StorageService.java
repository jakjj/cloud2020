package org.weizhen.seata.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.weizhen.springcloud.entities.CommonResult;

@FeignClient(value = "seata-storage-server")
public interface StorageService {

    @GetMapping(value = "/storage/decrease")
    CommonResult<String> decrease (@RequestParam(value = "productId") Long productId
                                , @RequestParam(value = "reduction") int reduction);
}
