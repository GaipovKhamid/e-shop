package com.e_commerce.e_commerce.login;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import com.e_commerce.e_commerce.exceptions.BadRequestException;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository loginRepository;

    @Override
    public AuthDTO createUser(AuthDTO authDTO) {
        var validForLowerCase = authDTO.getEmail().toLowerCase();

        if (loginRepository.existsByEmail(validForLowerCase)) {
            throw new DuplicateException("Email already in use");
        }

        AuthEntity entity = new AuthEntity();
        entity.setEmail(authDTO.getEmail());
        entity.setPassword(authDTO.getPassword());
        entity.setRole(authDTO.getRole());
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

    @Override
    public ListDto<AuthDTO> getUsers(Pageable pageable) {
        List<AuthDTO> authDTOList = loginRepository.findAll(pageable).getContent().stream()
                .map(authEntity ->
                        AuthDTO.builder()
                                .id(authEntity.getId())
                                .email(authEntity.getEmail())
                                .password(authEntity.getPassword())
                                .build())
                .toList();
        return new ListDto<>(authDTOList);
    }

    @Override
    public boolean signIn(AuthDTO authDTO) {
        AuthEntity loginEntity;
        loginEntity = loginRepository.findByEmail(authDTO.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Email not found"));

        if (StringUtils.hasText(loginEntity.getEmail()) && loginEntity.getEmail().equals(authDTO.getEmail())) {
            if (StringUtils.hasText(loginEntity.getPassword()) && loginEntity.getPassword().equals(authDTO.getPassword())) {
            } else {
                throw new BadRequestException("Passwords do not match");
            }
        }
        throw new BadRequestException("Invalid email or password");
    }

}
