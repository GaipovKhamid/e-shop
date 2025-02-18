package com.e_commerce.e_commerce.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);

    Optional<CategoryEntity> findByIdAndDeletedAtIsNull(Long id);
}
