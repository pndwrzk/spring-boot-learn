package com.learn.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learn.ecommerce.model.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    Page<ProductEntity> findAll(Pageable pageable);
    Page<ProductEntity> findByNameContainsIgnoreCaseAndDescriptionContainsIgnoreCase(String name, String description, Pageable pageable);

    // @Query("""
    //        SELECT product FROM ProductEntity product WHERE
    //        LOWER(product.name) LIKE LOWER(CONCAT('%', :query, '%')) OR 
    //        LOWER(product.description) LIKE LOWER(CONCAT('%', :query, '%'))
    //        """)
    // Page<ProductEntity> filter(String query, Pageable pageable);

    @Query("""
        SELECT product FROM ProductEntity product WHERE
        (LOWER(product.name) LIKE LOWER(CONCAT('%', :query, '%')) OR 
        LOWER(product.description) LIKE LOWER(CONCAT('%', :query, '%')))
        AND product.category.id = :categoryId
        """)
 Page<ProductEntity> filter(String query,Integer categoryId ,Pageable pageable);
}
