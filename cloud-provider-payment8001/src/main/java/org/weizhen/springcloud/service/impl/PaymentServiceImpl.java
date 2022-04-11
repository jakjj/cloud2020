package org.weizhen.springcloud.service.impl;

import org.springframework.stereotype.Service;
import org.weizhen.springcloud.dao.PaymentDao;
import org.weizhen.springcloud.service.PaymentService;
import org.weizhen.springcloud.entities.Payment;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int addInfo(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getInfoById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
