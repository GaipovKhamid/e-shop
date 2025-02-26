package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;


public interface ProductsService {
    ProductsDTO addProduct(ProductsDTO productsDTO);

    ListDto<ProductsDTO> getProducts(Pageable pageable);

    ProductsDTO updateProduct(Long id, ProductsDTO productsDTO);

    void deleteUser(Long id);

    ListDto<ProductsDTO> searchProduct(ProductsDTO productsDTO, Pageable pageable);

}
