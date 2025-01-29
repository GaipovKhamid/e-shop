package com.e_commerce.e_commerce.Buy;

import jakarta.persistence.*;

@Entity
@Table(name = "buy_tab")
public class BuyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
