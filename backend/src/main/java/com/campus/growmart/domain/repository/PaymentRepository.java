package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Object> {

}
