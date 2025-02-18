package com.e_commerce.e_commerce.category;

import com.e_commerce.e_commerce.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
