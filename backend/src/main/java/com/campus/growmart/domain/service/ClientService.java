package com.campus.growmart.domain.service;

import java.util.List;

import com.campus.growmart.persistence.dto.ClientDTO;
import com.campus.growmart.persistence.entity.Employee;

public interface ClientService {

    List<ClientDTO> findByCountryLike(String country);
    List<ClientDTO> findDistinctByCityAndSalesRepresentativeEmployeeCode(String city, Employee employee);
    
}
