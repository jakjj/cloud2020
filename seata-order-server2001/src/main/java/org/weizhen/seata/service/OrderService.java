package org.weizhen.seata.service;

import org.weizhen.springcloud.entities.Order;

public interface OrderService {

    int create(Order order);
}
