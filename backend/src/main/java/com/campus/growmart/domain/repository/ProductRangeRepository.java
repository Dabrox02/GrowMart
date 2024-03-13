package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.ProductRange;

public interface ProductRangeRepository extends JpaRepository<ProductRange, String> {

}
