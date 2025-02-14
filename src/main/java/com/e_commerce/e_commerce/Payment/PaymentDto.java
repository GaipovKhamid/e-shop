package com.e_commerce.e_commerce.Payment;

public class PaymentDto {
    private Long id;  // Changed to Long
    private Long cartId;
    private String cardNum;  // Changed to String to store card numbers as strings

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
