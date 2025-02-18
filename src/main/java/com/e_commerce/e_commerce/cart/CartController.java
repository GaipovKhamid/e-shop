package com.e_commerce.e_commerce.cart;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<CartDto> create(@RequestBody CartDto cartDto){
        CartDto r = cartService.addProductToCart(cartDto);
        return ResponseEntity.ok(r);
    }

    @GetMapping("/all")
    public ResponseEntity<ListDto<CartDto>> all(Pageable pageable){
        return ResponseEntity.ok(cartService.viewAll(pageable));
    }

}
