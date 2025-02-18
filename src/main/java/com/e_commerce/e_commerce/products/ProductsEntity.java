package com.e_commerce.e_commerce.products;


import com.e_commerce.e_commerce.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Table(name = "product")
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductsEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private Double price;

    @Column
    private Long quantity;

}
