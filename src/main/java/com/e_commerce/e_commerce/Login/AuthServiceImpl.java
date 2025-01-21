package com.e_commerce.e_commerce.Login;

import com.e_commerce.e_commerce.common.BaseEntity;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthRepository loginRepository;

    public AuthServiceImpl(AuthRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public AuthDTO createUser(AuthDTO authDTO) {
        if (loginRepository.existsByEmail(authDTO.getEmail())) {
            throw new DuplicateException("Email already in use");
        }

        AuthEntity entity = new AuthEntity();
        entity.setEmail(authDTO.getEmail());
        entity.setPassword(authDTO.getPassword());

        loginRepository.save(entity);
        authDTO.setId(entity.getId());

        return authDTO;
    }
}
