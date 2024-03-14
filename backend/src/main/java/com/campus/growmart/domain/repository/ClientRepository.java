package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Devuelve un listado con el nombre de los todos los clientes españoles.
    List<Object> findByCountryLike(String country);

}
