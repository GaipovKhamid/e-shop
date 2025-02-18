package com.e_commerce.e_commerce.category;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;


@Service
public interface CategoryService {
    ListDto<CategoryDTO> getAll(Pageable pageable);

    CategoryDTO create(CategoryDTO categoryDTO);

    CategoryDTO update(Long id, CategoryDTO categoryDTO);

    CategoryEntity findById(Long id);

    void delete(Long id);
}
