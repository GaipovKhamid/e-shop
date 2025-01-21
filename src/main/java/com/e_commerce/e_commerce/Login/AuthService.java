package com.e_commerce.e_commerce.Login;

import com.e_commerce.e_commerce.exceptions.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public AuthDTO createUser(AuthDTO authDTO) {
        if (authRepository.existsByEmail(authDTO.getEmail())) {
            throw new DuplicateException("Email already in use");
        }

        AuthEntity entity = new AuthEntity();
        entity.setEmail(authDTO.getEmail());
        entity.setPassword(authDTO.getPassword());

        authRepository.save(entity);
        authDTO.setId(entity.getId());

        return authDTO;
    }
}
