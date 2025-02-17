package com.e_commerce.e_commerce.Category;


import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCartegory(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.create(categoryDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<ListDto<CategoryDTO>> getAllCategory(Pageable pageable) {
        return ResponseEntity.ok(categoryService.getAll(pageable));
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long name, @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.update(name, categoryDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
