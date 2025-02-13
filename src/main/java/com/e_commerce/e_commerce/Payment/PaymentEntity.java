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

    @Column(name = "prices")
    private Double prices;

    @Column
    private Integer cardNum;

    @Column
    private PaidStatus status;

    public PaidStatus getStatus() {
        return status;
    }

    public Integer getCardNum() {
        return cardNum;
    }

    public void setCardNum(Integer cardNum) {
        this.cardNum = cardNum;
    }

    public void setStatus(PaidStatus status) {
        this.status = status;
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

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }
}
