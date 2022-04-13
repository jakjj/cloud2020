package org.weizhen.seata.service;


import feign.Param;

public interface StorageService {

    /**
     * 减少对应产品的库存
     * @param productId
     * @param reduction
     * @return
     */
    int decrease(Long productId, Integer reduction);
}
