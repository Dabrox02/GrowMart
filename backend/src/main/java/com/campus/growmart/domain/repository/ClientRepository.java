package com.campus.growmart.domain.repository;

import java.util.List;

import com.campus.growmart.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Devuelve un listado con el nombre de los todos los clientes españoles.
    List<Object> findByCountryLike(String country);

    // Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 30.
    List<Object> findDistinctByCityAndSalesRepresentativeEmployeeCode(String city, Employee employeeCode);


}
