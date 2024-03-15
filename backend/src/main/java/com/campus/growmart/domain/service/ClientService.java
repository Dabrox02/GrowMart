package com.campus.growmart.domain.service;

import java.util.List;
import java.util.Map;

import com.campus.growmart.persistence.dto.ClientDTO;
import com.campus.growmart.persistence.entity.Employee;

public interface ClientService {

    List<ClientDTO> findByCountryLike(String country);
    List<ClientDTO> findDistinctByCityAndSalesRepresentativeEmployeeCode(String city, Employee employee);
    Map<String, Long> countByCountry();
    
}
