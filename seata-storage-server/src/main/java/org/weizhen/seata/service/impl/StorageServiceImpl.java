package org.weizhen.seata.service.impl;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizhen.seata.dao.StorageDao;
import org.weizhen.seata.service.StorageService;

import javax.annotation.Resource;

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    StorageDao storageDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int decrease(Long productId, Integer reduction) {
        log.info("------storage'sXID: " + RootContext.getXID());
        log.info("扣款报个错");
        int i = 1/0;
        return storageDao.decrease(productId, reduction);
    }
}
