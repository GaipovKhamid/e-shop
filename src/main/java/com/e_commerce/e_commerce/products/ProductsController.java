package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/prod")
@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

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

    @GetMapping("/byPrice")
    public ResponseEntity<ListDto<ProductsDTO>> searchByPrice(@RequestParam Double price1,
                                                              @RequestParam Double price2,
                                                              ProductsDTO productsDTO,
                                                              Pageable pageable) {
        return ResponseEntity.ok(productsService.searchProductByTwoPrices(productsDTO, price1, price2, pageable));
    }

}
