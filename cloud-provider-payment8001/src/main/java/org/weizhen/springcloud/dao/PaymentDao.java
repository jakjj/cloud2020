package org.weizhen.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.weizhen.springcloud.entities.Payment;

@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
