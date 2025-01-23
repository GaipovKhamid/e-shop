package com.e_commerce.e_commerce.Login;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    AuthDTO createUser(AuthDTO authDTO);

    AuthDTO updateUser(Long id, AuthDTO authDTO);

    void deleteUser(Long id);
}
