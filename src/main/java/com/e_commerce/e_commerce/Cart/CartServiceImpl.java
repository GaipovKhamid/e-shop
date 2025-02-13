package com.e_commerce.e_commerce.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository repository;
    @Override
    public CartDto addProductToCart(CartDto cartDto) {
        CartEntity entity = new CartEntity();
        entity.setProductId(cartDto.getProductId());
        entity.setUserId(cartDto.getUserId());
        entity.setCreatedAt(LocalDateTime.now());

        System.out.println(cartDto.toString());
        repository.save(entity);
        cartDto.setId(entity.getId());

        return cartDto;
    }

    @Override
    public List<CartDto> viewAll() {
        Iterable<CartEntity> iterator = repository.findAll();
        List<CartDto> list = new LinkedList<>();
        for (CartEntity entity : iterator) {
            CartDto dto = new CartDto();
            dto.setId(entity.getId());
            list.add(dto);
        }
        return list;
    }
}
