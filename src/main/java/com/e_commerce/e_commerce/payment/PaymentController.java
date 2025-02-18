package com.e_commerce.e_commerce.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/pay")
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/buy")
    public ResponseEntity<PaymentDto> create(@RequestBody PaymentDto dto) {
        return ResponseEntity.ok(paymentService.createPay(dto));
    }
}
