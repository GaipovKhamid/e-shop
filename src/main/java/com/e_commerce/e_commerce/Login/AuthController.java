package com.e_commerce.e_commerce.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController("test123")
public class AuthController {

    @Autowired
    AuthService authService;


    @PostMapping("/create")
    public ResponseEntity<AuthDTO> create(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(authService.createUser(authDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuthDTO> update(@RequestBody AuthDTO authDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(authService.updateUser(id, authDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthDTO> delete(@PathVariable("id") Long id) {
        authService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
