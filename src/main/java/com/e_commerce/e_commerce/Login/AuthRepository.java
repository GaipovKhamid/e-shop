package com.e_commerce.e_commerce.Login;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Integer> {
    boolean existsByEmail(String email);

    Optional<AuthEntity> findById(Long id);

    Optional<AuthEntity> findByEmail(String email);


}
