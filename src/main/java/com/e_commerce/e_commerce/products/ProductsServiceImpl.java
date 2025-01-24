package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.exceptions.BadRequestException;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public ProductsDTO addProduct(ProductsDTO productsDTO) {
        if (productsRepository.existsByProductName(productsDTO.getProductName())) {
            throw new DuplicateException(productsDTO.getProductName() + " already exists");
        }

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setProductName(productsDTO.getProductName());
        productsEntity.setPrice(productsDTO.getPrice());
        productsEntity.setQuantity(productsDTO.getQuantity());
        productsEntity.setCategory(productsDTO.getCategory());
        productsEntity.setCreatedAt(LocalDateTime.now());


        if (productsEntity.getPrice() == null) {
            throw new BadRequestException("Price cannot be null");
        }

        productsRepository.save(productsEntity);
        productsDTO.setId(productsEntity.getId());

        return productsDTO;
    }

    @Override
    public ProductsDTO updateProduct(Long id, ProductsDTO productsDTO) {
        Optional<ProductsEntity> optional = productsRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("Product not found");
        }

        if (optional.get().getDeletedAt() != null) {
            throw new DuplicateException("Product already in use");
        }

        ProductsEntity entity = optional.get();
        entity.setProductName(productsDTO.getProductName());
        entity.setPrice(productsDTO.getPrice());
        entity.setQuantity(productsDTO.getQuantity());
        entity.setCategory(productsDTO.getCategory());
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
        Optional<ProductsEntity> optional = productsRepository.findById(id);
        if (optional.get().getDeletedAt() != null) {
            throw new BadRequestException("This product has been deleted");
        }

        ProductsEntity entity = optional.get();
        entity.setDeletedAt(LocalDateTime.now());
        productsRepository.save(entity);
    }

    @Override
    public List<ProductsDTO> getUsers() {
        Iterable<ProductsEntity> iterator = productsRepository.findAll(); //iterable = for each da aylantirish uchun royihatni retunr atadi
        List<ProductsDTO> list = new LinkedList<>();
        for (ProductsEntity entity : iterator) {
            ProductsDTO dto = new ProductsDTO();
            dto.setId(entity.getId());
            dto.setProductName(entity.getProductName());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());
            dto.setCategory(entity.getCategory());

            list.add(dto);
        }

        return list;
    }
}
