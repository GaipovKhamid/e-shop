package com.e_commerce.e_commerce.products;

import com.e_commerce.e_commerce.Category.CategoryService;
import com.e_commerce.e_commerce.exceptions.BadRequestException;
import com.e_commerce.e_commerce.exceptions.DuplicateException;
import com.e_commerce.e_commerce.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    private final CategoryService categoryService;

    public ProductsServiceImpl(ProductsRepository productsRepository, CategoryService categoryService) {
        this.productsRepository = productsRepository;
        this.categoryService = categoryService;
    }

    @Override
    public ProductsDTO addProduct(ProductsDTO productsDTO) {
        if (productsRepository.existsByProductName(productsDTO.getProductName())) {
            throw new DuplicateException(productsDTO.getProductName() + " already exists");
        }
        var category = categoryService.findById(productsDTO.getCategoryId());

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
    public Page<ProductsDTO> getProducts(Pageable pageable) {
//        return productsRepository.getPagetest(pageable);
        return null;
    }

    //map set list

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

    @Override
    public List<ProductsDTO> getUsers() {
        var iterator = productsRepository.findAllByDeletedAtIsNull(); //iterable = for each da aylantirish uchun royihatni retunr atadi
        List<ProductsDTO> list = new LinkedList<>();
        for (ProductsEntity entity : iterator) {
            ProductsDTO dto = new ProductsDTO();
            dto.setId(entity.getId());
            dto.setProductName(entity.getProductName());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());

            list.add(dto);
        }

        return list;
    }
}
