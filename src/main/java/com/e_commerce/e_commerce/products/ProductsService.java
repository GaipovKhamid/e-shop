package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.category.CategoryDTO;
import com.e_commerce.e_commerce.common.dtos.ListDto;
import org.springframework.data.domain.Pageable;


public interface ProductsService {
    ProductsDTO addProduct(ProductsDTO productsDTO);

    ListDto<ProductsDTO> getProducts(Pageable pageable);

    ProductsDTO updateProduct(Long id, ProductsDTO productsDTO);

    void deleteProduct(Long id);

    ListDto<ProductsDTO> searchProduct(ProductsDTO productsDTO, Pageable pageable);

    ListDto<ProductsDTO> searchProductByTwoPrices(ProductsDTO dto, Double price1, Double price2, Pageable pageable);
}
