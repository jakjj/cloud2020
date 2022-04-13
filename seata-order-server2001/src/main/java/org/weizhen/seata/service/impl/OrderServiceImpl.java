package org.weizhen.seata.service.impl;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weizhen.seata.dao.OrderDao;
import org.weizhen.seata.service.AccountService;
import org.weizhen.seata.service.OrderService;
import org.weizhen.seata.service.StorageService;
import org.weizhen.springcloud.entities.Order;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "order-Global")
    @Transactional(rollbackFor = Exception.class)
    public int create(Order order) {
        log.info("------order'sXID: " + RootContext.getXID());

        log.info("开始创建order");
        int id = orderDao.create(order);
        log.info("开始调用库存，扣减库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("开始调用库存，扣减用户积分");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("修改订单状态");
        orderDao.update(order.getUserId(),1, order.getId());
        return 0;
    }
}
