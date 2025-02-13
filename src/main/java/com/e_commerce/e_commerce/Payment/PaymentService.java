package com.e_commerce.e_commerce.Payment;

import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    PaymentDto createPay(PaymentDto dto);
}
