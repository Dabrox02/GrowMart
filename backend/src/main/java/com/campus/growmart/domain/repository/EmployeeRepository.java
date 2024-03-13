package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
