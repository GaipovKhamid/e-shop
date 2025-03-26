package com.e_commerce.e_commerce.payment;

import com.e_commerce.e_commerce.cart.CartEntity;
import com.e_commerce.e_commerce.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
    @Enumerated(EnumType.STRING)
    private PaidStatus status;
}
