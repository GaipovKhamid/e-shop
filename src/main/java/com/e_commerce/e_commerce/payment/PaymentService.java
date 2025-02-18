package com.e_commerce.e_commerce.payment;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    PaymentDto createPay(PaymentDto dto);
}
