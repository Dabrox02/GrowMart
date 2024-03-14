package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {

    // Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
    @Query("SELECT o.officeCode, o.city FROM Office o")
    List<Object[]> findOfficeCodesAndCities();

    // Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
    List<Object> findByCountryIgnoreCase(String country);

}
