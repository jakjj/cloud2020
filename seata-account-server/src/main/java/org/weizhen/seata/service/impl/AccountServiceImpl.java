package org.weizhen.seata.service.impl;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizhen.seata.dao.AccountDao;
import org.weizhen.seata.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int decrease(Long userId, BigDecimal reduction) {
        log.info("------account'sXID: " + RootContext.getXID());
        log.info("开始扣款");
        accountDao.decrease(userId, reduction);
        return 0;
    }
}
