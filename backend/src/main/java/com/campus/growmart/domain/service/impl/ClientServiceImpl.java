package com.campus.growmart.domain.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.campus.growmart.persistence.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.ClientRepository;
import com.campus.growmart.domain.service.ClientService;
import com.campus.growmart.persistence.dto.ClientDTO;
import com.campus.growmart.persistence.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> findByCountryLike(String country) {
        List<Object> results = clientRepository.findByCountryLike(country);

        return results.stream()
                .map(obj -> {
                    Client client = (Client) obj;
                    ClientDTO clientDTO = new ClientDTO();
                    clientDTO.setClientName(client.getClientName());
                    return clientDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findClientsWithPayment() {
        List<Object[]> results = clientRepository.findClientsWithPayment();

        return results.stream()
                .map(obj -> {
                    ClientDTO clientDTO = new ClientDTO();
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    clientDTO.setClientName((String) obj[0]);
                    employeeDTO.setName((String) obj[1]);
                    employeeDTO.setSurname1((String) obj[2]);
                    clientDTO.setSalesRepresentativeEmployeeCode(employeeDTO);
                    return clientDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findClientsWithNoPayment() {
        List<Object[]> results = clientRepository.findClientsWithNoPayment();

        return results.stream()
                .map(obj -> {
                    ClientDTO clientDTO = new ClientDTO();
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    clientDTO.setClientName((String) obj[0]);
                    employeeDTO.setName((String) obj[1]);
                    employeeDTO.setSurname1((String) obj[2]);
                    clientDTO.setSalesRepresentativeEmployeeCode(employeeDTO);
                    return clientDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ClientDTO> findClientByCityAndEmployeeCode(String city, String employeeCode1, String employeeCode2) {
        List<Object[]> results = clientRepository.findClientByCityAndEmployeeCode(city, employeeCode1, employeeCode2);
        return results.stream().map(obj -> {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientCode((Integer) obj[0]);
            clientDTO.setClientName((String) obj[1]);
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeCode((Integer) obj[2]);
            clientDTO.setSalesRepresentativeEmployeeCode(employeeDTO);
            clientDTO.setCity((String) obj[3]);
            return clientDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> countByCountry() {
        List<Object[]> results = clientRepository.countByCountry();

        List<Map<String, Object>> dataList = new ArrayList<>();
        results.stream().forEach(obj -> {

            Map<String, Object> clientsByCountry = new HashMap<>();
            clientsByCountry.put("country", (String) obj[0]);
            clientsByCountry.put("client_amount", (Long) obj[1]);
            dataList.add(clientsByCountry);
        });

        return dataList;
    }

    @Override
    public Map<String, Object> count() {
        long results = clientRepository.count();
        Map<String, Object> clientsAmount = new HashMap<>();
        clientsAmount.put("clients_amount", results);

        return clientsAmount;
    }

    @Override
    public Map<String, Object> countByCity(String city) {
        long results = clientRepository.countByCity(city);
        Map<String, Object> clientsAmountPerCity = new HashMap<>();
        clientsAmountPerCity.put("city", city);
        clientsAmountPerCity.put("client_amount", results);
        return clientsAmountPerCity;
    }

    @Override
    public List<Map<String, Object>> countClientsCityBeginWith(String initialLetterCity) {
        List<Object[]> results = clientRepository.countClientsCityBeginWith(initialLetterCity);
        List<Map<String, Object>> dataList = new ArrayList<>();

        results.stream().forEach(obj -> {
            Map<String, Object> clientsCityBeginWith = new HashMap<>();
            clientsCityBeginWith.put("clients_amount", obj[0]);
            clientsCityBeginWith.put("city", obj[1]);
            dataList.add(clientsCityBeginWith);

        });
        return dataList;
    }

    @Override
    public Map<String, Object> clientAmountWithoutEmployee() {
        List<Object> results = clientRepository.clientAmountWithoutEmployee();
        Map<String, Object> clientsWithoutEmployess = new HashMap<>();
        results.stream().forEach(obj -> {
            clientsWithoutEmployess.put("amount_clients_without_employee", obj);
        });
        return clientsWithoutEmployess;
    }

    @Override
    public List<Map<String, Object>> clientFirstLastPayment() {
        List<Object[]> results = clientRepository.clientFirstLastPayment();
        List<Map<String, Object>> dataList = new ArrayList<>();
        results.stream().forEach(obj -> {
            Map<String, Object> firstLastPayment = new HashMap<>();
            firstLastPayment.put("client_name", obj[0]);
            firstLastPayment.put("contact_name", obj[1]);
            firstLastPayment.put("contact_surname", obj[2]);
            firstLastPayment.put("first_payment", obj[3]);
            firstLastPayment.put("last_payment", obj[4]);
            dataList.add(firstLastPayment);
        }

        );
        return dataList;
    }

}
