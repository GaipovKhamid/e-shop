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

    @PostMapping("/add/{id}")
    public ResponseEntity<CartDto> create(@PathVariable("id") CartDto cartDto){
        return ResponseEntity.ok(cartService.addProductToCart(cartDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CartDto>> all(){
        return ResponseEntity.ok(cartService.viewAll());
    }

}
