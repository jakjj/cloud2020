package org.weizhen.springcloud.service;


import org.weizhen.springcloud.entities.Payment;

public interface PaymentService {
    int addInfo(Payment payment);

    Payment getInfoById(Long id);
}
