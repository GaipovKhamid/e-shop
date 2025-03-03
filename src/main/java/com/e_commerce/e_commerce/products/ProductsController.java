package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/prod")
@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @PostMapping("/add")
    public ResponseEntity<ProductsDTO> create(@RequestBody ProductsDTO productsDTO) {
        return ResponseEntity.ok(productsService.addProduct(productsDTO));
    }

    @GetMapping("/all-page")
    public ResponseEntity<ListDto<ProductsDTO>> getAllProductsPage(Pageable pageable) {
        return ResponseEntity.ok(productsService.getProducts(pageable));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductsDTO> update(@RequestBody ProductsDTO productsDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(productsService.updateProduct(id, productsDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProductsDTO> deleteProduct(@PathVariable("id") Long id) {
        productsService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<ListDto<ProductsDTO>> searchProduct(@RequestParam String productName, ProductsDTO dto, Pageable pageable) {
        return ResponseEntity.ok(productsService.searchProduct(dto, pageable));
    }

    @GetMapping("/searchByCategory") 
    public ResponseEntity<ListDto<ProductsDTO>> searchProductByCategory(@RequestParam String category, ProductsDTO productsDTO, Pageable pageable) {
        return ResponseEntity.ok(productsService.searchProductByCategory(productsDTO,pageable));
    }

}
