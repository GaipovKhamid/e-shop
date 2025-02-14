package com.e_commerce.e_commerce.Payment;

import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public PaymentDto createPay(PaymentDto dto) {
        PaymentEntity paymentEntity = new PaymentEntity();

        // Проверяем длину номера карты
        if (dto.getCardNum() == null || dto.getCardNum().length() != 16) {
            throw new ResourceNotFoundException("You have to enter real card number.");
        }

        paymentEntity.setCartId(dto.getCartId());
        paymentEntity.setCardNum(dto.getCardNum());  // Теперь передаем строку вместо Long
        paymentEntity.setCreatedAt(LocalDateTime.now());

        paymentRepository.save(paymentEntity);
        dto.setId(paymentEntity.getId());
        return dto;
    }

}
