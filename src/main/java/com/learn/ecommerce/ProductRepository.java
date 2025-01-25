package com.learn.ecommerce;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.ecommerce.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    Page<ProductEntity>findAll(Pageable pageable);
    Page<ProductEntity>findByNameContainsIgnoreCaseAndDescriptionContainsIgnoreCase(String name, String description, Pageable pageable);

   
}