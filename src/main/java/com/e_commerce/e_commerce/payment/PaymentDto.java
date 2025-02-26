package com.e_commerce.e_commerce.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDto {
    private Long id;
    private Long cartId;
    private String cardNum;
    private String cardType;
    private PaidStatus status;

}
