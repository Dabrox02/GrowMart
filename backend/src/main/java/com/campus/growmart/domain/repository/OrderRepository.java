package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
