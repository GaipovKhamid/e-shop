package com.e_commerce.e_commerce.Category;

import com.e_commerce.e_commerce.Login.AuthEntity;
import com.e_commerce.e_commerce.exceptions.BadRequestException;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAll() {
        Iterable<CategoryEntity> iterator = categoryRepository.findAll();
        List<CategoryDTO> list = new LinkedList<>();
        for (CategoryEntity entity : iterator) {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            list.add(dto);
        }

        return list;
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
                .orElseThrow(()-> new ResourceNotFoundException(id.toString()));
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
