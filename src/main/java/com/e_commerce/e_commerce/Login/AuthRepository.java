package com.e_commerce.e_commerce.Login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends CrudRepository<AuthEntity, Integer> {
    boolean existsByEmail(String email);

    Optional<AuthEntity> findById(Long id);

}
