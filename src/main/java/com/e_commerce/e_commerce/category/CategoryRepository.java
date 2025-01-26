package com.e_commerce.e_commerce.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    boolean existsByName(String name);
}
