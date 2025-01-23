package com.e_commerce.e_commerce.Login;

import com.e_commerce.e_commerce.exceptions.BadRequestException;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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
        entity.setCreatedAt(LocalDateTime.now());

        if (entity.getDeletedAt() != null) {
            throw new DuplicateException("Email already in use");
        }
        loginRepository.save(entity);
        authDTO.setId(entity.getId());

        return authDTO;
    }

    @Override
    public AuthDTO updateUser(Long id, AuthDTO authDTO) {
        Optional<AuthEntity> optional = loginRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }

        if (optional.get().getDeletedAt() != null) {
            throw new DuplicateException("Email already in use");
        }

        AuthEntity entity = optional.get();
        entity.setEmail(authDTO.getEmail());
        entity.setPassword(authDTO.getPassword());
        entity.setUpdatedAt(LocalDateTime.now());

        if (loginRepository.existsByEmail(authDTO.getEmail())) {
            throw new DuplicateException("Email exist");
        }

        loginRepository.save(entity);
        authDTO.setId(entity.getId());

        return authDTO;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<AuthEntity> optional = loginRepository.findById(id);
        if (optional.get().getDeletedAt() != null) {
            throw new BadRequestException("This user has been deleted");
        }

        AuthEntity entity = optional.get();
        entity.setDeletedAt(LocalDateTime.now());
        loginRepository.save(entity);
    }

}
