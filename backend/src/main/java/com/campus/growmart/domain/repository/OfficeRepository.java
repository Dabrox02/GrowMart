package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {

}
