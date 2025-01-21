package com.e_commerce.e_commerce.Login;

import com.e_commerce.e_commerce.exceptions.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController("test123")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/create")
    public ResponseEntity<AuthDTO> create(AuthDTO authDTO) {
        try {
            AuthDTO createdUser = authService.createUser(authDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (DuplicateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // 409 Conflict

        }
    }

}
