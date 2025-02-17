package com.e_commerce.e_commerce.Login;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthService {
    AuthDTO createUser(AuthDTO authDTO);

    AuthDTO updateUser(Long id, AuthDTO authDTO);

    void deleteUser(Long id);

    ListDto<AuthDTO> getUsers(Pageable pageable);


    boolean signIn(AuthDTO authDTO);
}
