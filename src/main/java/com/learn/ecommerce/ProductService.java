package com.learn.ecommerce;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.learn.ecommerce.entity.ProductEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductEntity> getTopTree() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<ProductEntity> products = productRepository.findAll(pageRequest);
        return  products.toList();
    }

    public List<ProductEntity> getProducts(Integer pageNumber, Integer pageSize, String q) {
        if(q != null) {
            PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize);
            Page<ProductEntity> products = productRepository.findByNameContainsIgnoreCaseAndDescriptionContainsIgnoreCase(q, q, pageRequest);
            return  products.toList();
        }
        PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize);
        Page<ProductEntity> products = productRepository.findAll(pageRequest);
        return  products.toList();
    }
}
