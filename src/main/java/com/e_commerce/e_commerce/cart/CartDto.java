package com.e_commerce.e_commerce.cart;

import com.e_commerce.e_commerce.payment.PaidStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartDto {
    private Long id;
    private Long userId;
    private Long productId;
    private PaidStatus status;

}
