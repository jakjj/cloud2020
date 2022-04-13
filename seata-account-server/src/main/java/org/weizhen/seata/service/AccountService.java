package org.weizhen.seata.service;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 减少对应用户的钱
     * @param userId
     * @param reduction
     * @return
     */
    int decrease(Long userId, BigDecimal reduction);
}
