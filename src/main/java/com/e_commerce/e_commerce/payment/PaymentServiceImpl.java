package com.e_commerce.e_commerce.payment;

import com.e_commerce.e_commerce.cart.CartEntity;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import com.e_commerce.e_commerce.products.ProductsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;


    @Override
    public PaymentDto createPay(PaymentDto dto) {
        PaymentEntity paymentEntity = new PaymentEntity();
        ProductsEntity productsEntity = new ProductsEntity();
        CartEntity cartEntity = new CartEntity();

        if (dto.getCardNum() == null || dto.getCardNum().length() != 16) {
            throw new ResourceNotFoundException("You have to enter real card number.");
        }

        paymentEntity.setCartId(dto.getCartId());
        paymentEntity.setCardNum(dto.getCardNum());
        productsEntity.setPrice(productsEntity.getPrice());

        if (paymentEntity.getCardNum().startsWith(CartType.UZCARD.getStartNum())) {
            paymentEntity.setCardType(CartType.UZCARD);
        }
        if (paymentEntity.getCardNum().startsWith(CartType.HUMO.getStartNum())) {
            paymentEntity.setCardType(CartType.HUMO);
        }
        if (paymentEntity.getCardNum().startsWith(CartType.VISA.getStartNum())) {
            paymentEntity.setCardType(CartType.VISA);
        }

        paymentEntity.setStatus(PaidStatus.PAID);

        paymentEntity.setCreatedAt(LocalDateTime.now());

        paymentRepository.save(paymentEntity);
        dto.setId(paymentEntity.getId());
        return dto;
    }

}
