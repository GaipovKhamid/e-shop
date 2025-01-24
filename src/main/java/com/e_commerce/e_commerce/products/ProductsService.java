package com.e_commerce.e_commerce.products;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    ProductsDTO addProduct(ProductsDTO productsDTO);

    ProductsDTO updateProduct(Long id, ProductsDTO productsDTO);

    void deleteUser(Long id);

    List<ProductsDTO> getUsers();
}
