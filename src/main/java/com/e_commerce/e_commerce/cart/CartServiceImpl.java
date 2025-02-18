package com.e_commerce.e_commerce.cart;

import com.e_commerce.e_commerce.payment.PaidStatus;
import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        entity.setStatus(PaidStatus.DONT_PAID);

        repository.save(entity);
        cartDto.setId(entity.getId());

        return cartDto;
    }

    @Override
    public ListDto<CartDto> viewAll(Pageable pageable) {
        List<CartDto> cartDtoList = repository.findAll(pageable).getContent().stream()
                .map(cartEntity ->
                        CartDto.builder()
                                .id(cartEntity.getId())
                                .status(cartEntity.getStatus())
                                .productId(cartEntity.getProductId())
                                .userId(cartEntity.getUserId())
                                .build())
                .toList();
        return new ListDto<>(cartDtoList);
    }
}
