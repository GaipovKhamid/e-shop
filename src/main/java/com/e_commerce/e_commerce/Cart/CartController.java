package com.e_commerce.e_commerce.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<CartDto>> all(){
        return ResponseEntity.ok(cartService.viewAll());
    }

}
