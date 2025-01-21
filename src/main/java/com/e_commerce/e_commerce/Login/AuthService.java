package com.e_commerce.e_commerce.Login;

import com.e_commerce.e_commerce.exceptions.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {
    AuthDTO createUser(AuthDTO authDTO);
}
