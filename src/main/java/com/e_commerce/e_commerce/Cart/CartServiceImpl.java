package com.e_commerce.e_commerce.Cart;

import com.e_commerce.e_commerce.Login.AuthEntity;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import com.e_commerce.e_commerce.products.ProductsEntity;
import com.e_commerce.e_commerce.products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository repository;

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public CartDto addProductToCart(CartDto cartDto) {
        AuthEntity authEntity = new AuthEntity();
        ProductsEntity products = new ProductsEntity();
        CartEntity entity = new CartEntity();
        if (authEntity.getId() == null && authEntity.getDeletedAt() != null) {
            throw new ResourceNotFoundException("User with " + authEntity.getId() + " not found");
        }
        if (products.getProductName() == null && products.getDeletedAt() != null) {
            throw new ResourceNotFoundException(products.getProductName() + " is not exist"); //todo
        }
        entity.setCreatedAt(LocalDateTime.now());
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
