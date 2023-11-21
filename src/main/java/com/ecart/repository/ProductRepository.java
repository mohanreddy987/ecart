package com.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecart.repository.models.ProductEntity;
/**
 * Product repository
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
