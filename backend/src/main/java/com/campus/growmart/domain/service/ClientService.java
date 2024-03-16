package com.campus.growmart.domain.service;

import java.util.List;
import java.util.Map;

import com.campus.growmart.persistence.dto.ClientDTO;
import com.campus.growmart.persistence.entity.Employee;

public interface ClientService {

    List<ClientDTO> findByCountryLike(String country);

    List<ClientDTO> findClientByCityAndEmployeeCode(String city, String employeeCode1, String employeeCode2);

    List<Map<String, Object>> countByCountry();

    Map<String, Object> count();

    Map<String, Object> countByCity(String city);

    List<Map<String, Object>> countClientsCityBeginWith(String initialLetterCity);

    Map<String, Object> clientAmountWithoutEmployee();

    List<Map<String, Object>> clientFirstLastPayment();

    List<ClientDTO> findClientsWithPayment();

    List<ClientDTO> findClientsWithNoPayment();

    List<ClientDTO> findClientsOfficeWithPayment();

    List<ClientDTO> findClientsOfficeWithNoPayment();

    List<ClientDTO> findClientWithSalesRepAndOffice();

    List<ClientDTO> findClientOrderNotInTime();

    List<ClientDTO> findClientProductRangePurchased();

    List<ClientDTO> findClientAllWithNoPayment();

    List<ClientDTO> findClientAllWithNoOrder();

    List<ClientDTO> findClientAllWithNoPaidNoOrder();

    List<ClientDTO> findClientOrderNoPaid();

    List<ClientDTO> findDistinctByCityAndSalesRepresentativeEmployeeCode(String city, Employee employee);
}
