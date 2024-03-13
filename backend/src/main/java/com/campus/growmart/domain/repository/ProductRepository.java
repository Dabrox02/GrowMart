package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
