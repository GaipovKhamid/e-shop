package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.common.dtos.ListDto;
import com.e_commerce.e_commerce.exceptions.BadRequestException;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;


    @Override
    public ProductsDTO addProduct(ProductsDTO productsDTO) {
        if (productsRepository.existsByProductName(productsDTO.getProductName())) {
            throw new DuplicateException(productsDTO.getProductName() + " already exists");
        }

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setProductName(productsDTO.getProductName());
        productsEntity.setPrice(productsDTO.getPrice());
        productsEntity.setQuantity(productsDTO.getQuantity());
        productsEntity.setCreatedAt(LocalDateTime.now());

        if (productsEntity.getPrice() == null) {
            throw new BadRequestException("Price cannot be null");
        }

        productsRepository.save(productsEntity);
        productsDTO.setId(productsEntity.getId());

        return productsDTO;
    }

    @Override
    public ListDto<ProductsDTO> getProducts(Pageable pageable) {
        List<ProductsDTO> productsDTOList = productsRepository.findAll(pageable).getContent().stream()
                .map(productsEntity ->
                        ProductsDTO.builder()
                                .id(productsEntity.getId())
                                .productName(productsEntity.getProductName())
                                .quantity(productsEntity.getQuantity())
                                .price(productsEntity.getPrice())
                                .build())
                .toList();
        return new ListDto<>(productsDTOList);
    }

    @Override
    public ProductsDTO updateProduct(Long id, ProductsDTO productsDTO) {
        ProductsEntity entity = productsRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));


        entity.setProductName(productsDTO.getProductName());
        entity.setPrice(productsDTO.getPrice());
        entity.setQuantity(productsDTO.getQuantity());
        entity.setUpdatedAt(LocalDateTime.now());

        if (productsRepository.existsByProductName(productsDTO.getProductName())) {
            throw new DuplicateException("Product exist");
        }

        productsRepository.save(entity);
        productsDTO.setId(entity.getId());

        return productsDTO;
    }

    @Override
    public void deleteUser(Long id) {
        ProductsEntity entity = productsRepository.findByIdAndDeletedAtIsNull(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));

        entity.setDeletedAt(LocalDateTime.now());
        productsRepository.save(entity);
    }

}
