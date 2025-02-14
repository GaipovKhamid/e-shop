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

        if (dto.getCardNum() == null || dto.getCardNum().length() != 16) {
            throw new ResourceNotFoundException("You have to enter real card number.");
        }

        paymentEntity.setCartId(dto.getCartId());
        paymentEntity.setCardNum(dto.getCardNum());
        paymentEntity.setStatus(PaidStatus.PAID);

        if (paymentEntity.getCardNum().startsWith("8600")) {
            paymentEntity.setCardType("UzCard");
        }
        if (paymentEntity.getCardNum().startsWith("9860")) {
            paymentEntity.setCardType("Humo");
        }
        if (paymentEntity.getCardNum().startsWith("4216")) {
            paymentEntity.setCardType("Visa");
        }

        if (paymentEntity.getStatus().equals(PaidStatus.PAID)) {
            throw new ResourceNotFoundException("You have already paid the card.");
        }
        paymentEntity.setCreatedAt(LocalDateTime.now());

        paymentRepository.save(paymentEntity);
        dto.setId(paymentEntity.getId());
        return dto;
    }

}
