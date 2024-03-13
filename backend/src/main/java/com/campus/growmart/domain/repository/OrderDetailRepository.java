package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Object> {
    
}
