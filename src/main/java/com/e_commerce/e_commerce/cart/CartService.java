package com.e_commerce.e_commerce.cart;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    CartDto addProductToCart(CartDto dto);

    ListDto<CartDto> viewAll(Pageable pageable);
}
