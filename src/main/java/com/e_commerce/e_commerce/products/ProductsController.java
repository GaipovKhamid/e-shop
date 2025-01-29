package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.Login.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/prod")
@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @PostMapping("/add")
    public ResponseEntity<ProductsDTO> create(@RequestBody ProductsDTO productsDTO) {
        return ResponseEntity.ok(productsService.addProduct(productsDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductsDTO>> getAllProducts() {
        return ResponseEntity.ok(productsService.getUsers());
    }

    @GetMapping("/all-page")
    public ResponseEntity<Page<ProductsDTO>> getAllProductsPage(Pageable pageable) {
        return ResponseEntity.ok(productsService.getProducts(pageable));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductsDTO> update(@RequestBody ProductsDTO productsDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(productsService.updateProduct(id, productsDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductsDTO> deleteProduct(@PathVariable("id") Long id) {
        productsService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
