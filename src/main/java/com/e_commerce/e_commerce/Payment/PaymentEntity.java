package com.e_commerce.e_commerce.Payment;

import com.e_commerce.e_commerce.Cart.CartEntity;
import com.e_commerce.e_commerce.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cart_id")
    private Long cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private CartEntity CartEntity;

    @Column
    private String cardNum;

    @Column
    @Enumerated(EnumType.STRING)
    private CartType cardType;


    @Column
    @Enumerated(EnumType.STRING)  //todo
    private PaidStatus status;

    public CartType getCardType() {
        return cardType;
    }

    public void setCardType(CartType cardType) {
        this.cardType = cardType;
    }

    public PaidStatus getStatus() {
        return status;
    }

    public void setStatus(PaidStatus status) {
        this.status = status;
    }

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

    public CartEntity getCartEntity() {
        return CartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        CartEntity = cartEntity;
    }
}
