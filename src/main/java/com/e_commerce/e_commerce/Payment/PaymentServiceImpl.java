package com.e_commerce.e_commerce.Payment;

import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import com.e_commerce.e_commerce.products.ProductsEntity;
import org.apache.coyote.BadRequestException;
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
        ProductsEntity productsEntity = new ProductsEntity();

        if (paymentEntity.getStatus() == PaidStatus.DONT_PAID) {
            throw new DuplicateException("This card is already payed.");
        }

        paymentEntity.setCartId(dto.getCartId());
        paymentEntity.setPrices(productsEntity.getPrice());

        if (paymentEntity.getCardNum().toString().length() != 16) {
            throw new ResourceNotFoundException("You have to enter real card number.");
        } else {
            paymentEntity.setCardNum(dto.getCardNum());
            paymentEntity.setStatus(PaidStatus.PAID);
            paymentEntity.setCreatedAt(LocalDateTime.now());
        }
        paymentRepository.save(paymentEntity);
        paymentEntity.setCartId(dto.getCartId());

        return dto;
    }
}
