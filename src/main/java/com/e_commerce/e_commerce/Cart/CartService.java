package com.e_commerce.e_commerce.Cart;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    CartDto addProductToCart(CartDto dto);

    List<CartDto> viewAll();
}
