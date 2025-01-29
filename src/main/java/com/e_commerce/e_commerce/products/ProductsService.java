package com.e_commerce.e_commerce.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductsService {
    ProductsDTO addProduct(ProductsDTO productsDTO);

    Page<ProductsDTO> getProducts(Pageable pageable);

    ProductsDTO updateProduct(Long id, ProductsDTO productsDTO);

    void deleteUser(Long id);

    List<ProductsDTO> getUsers();
}
