package com.learn.ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.learn.ecommerce.model.entity.ProductEntity;
import com.learn.ecommerce.model.response.PaggingInfo;
import com.learn.ecommerce.repository.ProductRepository;

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

    public PaggingInfo<ProductEntity> getProducts(Integer pageNumber, Integer pageSize, String q, Integer categoryId) {
        if(q != null) {
            PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize);
            //Page<ProductEntity> products = productRepository.findByNameContainsIgnoreCaseAndDescriptionContainsIgnoreCase(q, q,pageRequest);
            Page<ProductEntity> products = productRepository.filter(q,categoryId,pageRequest);
            return  PaggingInfo.convertFromPage(products);
        }
        PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize);
        Page<ProductEntity> products = productRepository.findAll(pageRequest);
        return PaggingInfo.convertFromPage(products);
    }
}
