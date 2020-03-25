package com.ine.cloud.service;

import com.ine.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
