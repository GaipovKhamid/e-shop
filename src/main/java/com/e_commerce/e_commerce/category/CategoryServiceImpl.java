package com.e_commerce.e_commerce.category;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import com.e_commerce.e_commerce.exceptions.BadRequestException;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public ListDto<CategoryDTO> getAll(Pageable pageable) {
        List<CategoryDTO> categoryDTOList = categoryRepository.findAll(pageable).getContent().stream()
                .map(categoryEntity ->
                        CategoryDTO.builder()
                                .id(categoryEntity.getId())
                                .name(categoryEntity.getName())
                                .build()
                )
                .toList();
        return new ListDto<>(categoryDTOList);
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();

        if (categoryEntity.getDeletedAt() != null) {
            throw new DuplicateException("Category deleted");
        }
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.getCreatedAt(LocalDateTime.now());

        categoryRepository.save(categoryEntity);
        categoryDTO.setId(categoryEntity.getId());
        return categoryDTO;
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        Optional<CategoryEntity> optional = categoryRepository.findById(id);

        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new DuplicateException("Category already exists");
        }

        CategoryEntity categoryEntity = optional.get();

        categoryEntity.setName(categoryDTO.getName());
        categoryEntity.setUpdatedAt(LocalDateTime.now());

        categoryRepository.save(categoryEntity);
        categoryDTO.setId(categoryEntity.getId());

        return categoryDTO;

    }

    @Override
    public CategoryEntity findById(Long id) {

        return categoryRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString()));
    }

    @Override
    public void delete(Long id) {
        Optional<CategoryEntity> optional = categoryRepository.findById(id);
        if (optional.get().getDeletedAt() != null) {
            throw new BadRequestException("This category has been deleted");
        }

        CategoryEntity entity = optional.get();
        entity.setDeletedAt(LocalDateTime.now());
        categoryRepository.save(entity);
    }
}
