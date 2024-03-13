package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
