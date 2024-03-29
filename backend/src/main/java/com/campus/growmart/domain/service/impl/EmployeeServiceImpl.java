package com.campus.growmart.domain.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.ClientRepository;
import com.campus.growmart.domain.repository.EmployeeRepository;
import com.campus.growmart.domain.service.EmployeeService;
import com.campus.growmart.persistence.dto.ClientDTO;
import com.campus.growmart.persistence.dto.EmployeeDTO;
import com.campus.growmart.persistence.dto.OfficeDTO;
import com.campus.growmart.persistence.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public List<EmployeeDTO> findNameLastnameByCodeBoss(Integer bossCode) {
        List<Object[]> results = employeeRepository.findNameLastnameByCodeBoss(bossCode);

        return results.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setName((String) row[0]);
                    employeeDTO.setSurname1((String) row[1]);
                    employeeDTO.setSurname2((String) row[2]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EmployeeDTO> findBossCompany() {
        List<Object[]> results = employeeRepository.findBossCompany();

        return results.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setName((String) row[0]);
                    employeeDTO.setSurname1((String) row[1]);
                    employeeDTO.setSurname2((String) row[2]);
                    employeeDTO.setEmail((String) row[3]);
                    employeeDTO.setPosition((String) row[4]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EmployeeDTO> findNameLastnamePositionNotLike(String position) {
        List<Object> results = employeeRepository.findByPositionNotLike(position);

        return results.stream()
                .map(row -> {
                    Employee employee = (Employee) row;
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setName(employee.getName());
                    employeeDTO.setSurname1(employee.getSurname1());
                    employeeDTO.setSurname2(employee.getSurname2());
                    employeeDTO.setPosition(employee.getPosition());
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> count() {
        long results = employeeRepository.count();
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> clientCount = new HashMap<>();
        clientCount.put("employee_amount", results);
        dataList.add(clientCount);
        return dataList;
    }

    @Override
    public List<Map<String, Object>> findEmployeeAmountClients() {
        List<Object[]> results = employeeRepository.findEmployeeAmountClients();
        List<Map<String, Object>> dataList = new ArrayList<>();

        results.stream().forEach(obj -> {
            Map<String, Object> employeeAmountCLients = new HashMap<>();
            employeeAmountCLients.put("employee_name", obj[0]);
            employeeAmountCLients.put("client_amount", obj[1]);
            dataList.add(employeeAmountCLients);
        });

        return dataList;
    }

    @Override
    @Transactional
    public List<EmployeeDTO> findNameClientWithSalesRep() {
        List<Object[]> results = clientRepository.findNameClientWithSalesRep();
        List<EmployeeDTO> employees = new ArrayList<>();

        for (Object[] obj : results) {
            String name = (String) obj[2];
            String surname1 = (String) obj[3];
            String surname2 = (String) obj[4];
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientName((String) obj[0]);

            boolean employeeFound = false;
            for (EmployeeDTO employeeDTO : employees) {
                if (employeeDTO.getName().equals(name) &&
                        employeeDTO.getSurname1().equals(surname1) &&
                        employeeDTO.getSurname2().equals(surname2)) {
                    employeeDTO.getClientList().add(clientDTO);
                    employeeFound = true;
                    break;
                }
            }
            if (!employeeFound) {
                EmployeeDTO newEmployee = new EmployeeDTO();
                newEmployee.setName(name);
                newEmployee.setSurname1(surname1);
                newEmployee.setSurname2(surname2);
                newEmployee.setClientList(new ArrayList<>());
                newEmployee.getClientList().add(clientDTO);
                employees.add(newEmployee);
            }
        }

        return employees;
    }

    @Override
    public List<EmployeeDTO> findNameEmployeeWithNameBoss() {
        List<Object[]> results = employeeRepository.findNameEmployeeWithNameBoss();

        return results.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    EmployeeDTO bossDTO = new EmployeeDTO();
                    employeeDTO.setName((String) row[0]);
                    employeeDTO.setSurname1((String) row[1]);
                    bossDTO.setName((String) row[2]);
                    bossDTO.setSurname1((String) row[3]);
                    employeeDTO.setBoss(bossDTO);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findEmployeeWithBossWithBoss() {
        List<Object[]> results = employeeRepository.findEmployeeWithBossWithBoss();
        return results.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    EmployeeDTO bossDTO = new EmployeeDTO();
                    EmployeeDTO bossDTO2 = new EmployeeDTO();
                    employeeDTO.setName((String) row[0]);
                    employeeDTO.setSurname1((String) row[1]);
                    bossDTO.setName((String) row[2]);
                    bossDTO.setSurname1((String) row[3]);
                    bossDTO2.setName((String) row[4]);
                    bossDTO2.setSurname1((String) row[5]);
                    bossDTO.setBoss(bossDTO2);
                    employeeDTO.setBoss(bossDTO);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findEmployeeAllNoOffice() {
        List<Object[]> results = employeeRepository.findEmployeeAllNoOffice();
        return results.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setEmployeeCode((Integer) row[0]);
                    employeeDTO.setName((String) row[1]);
                    employeeDTO.setSurname1((String) row[2]);
                    employeeDTO.setSurname2((String) row[3]);
                    employeeDTO.setPosition((String) row[4]);
                    employeeDTO.setEmail((String) row[5]);
                    employeeDTO.setExtension((String) row[6]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findEmployeeAllNoClient() {
        List<Object[]> results = employeeRepository.findEmployeeAllNoClient();
        return results.stream()
                .map(row -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    employeeDTO.setEmployeeCode((Integer) row[0]);
                    employeeDTO.setName((String) row[1]);
                    employeeDTO.setSurname1((String) row[2]);
                    employeeDTO.setSurname2((String) row[3]);
                    employeeDTO.setPosition((String) row[4]);
                    employeeDTO.setEmail((String) row[5]);
                    employeeDTO.setExtension((String) row[6]);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findEmployeeOfficeNoClient() {
        List<Object[]> results = employeeRepository.findEmployeeOfficeNoClient();
        return results.stream().map(obj -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setName((String) obj[0]);
            employeeDTO.setSurname1((String) obj[1]);
            employeeDTO.setSurname2((String) obj[2]);
            employeeDTO.setExtension((String) obj[3]);
            employeeDTO.setEmail((String) obj[4]);
            employeeDTO.setPosition((String) obj[5]);
            OfficeDTO officeDTO = new OfficeDTO();
            officeDTO.setCity((String) obj[6]);
            officeDTO.setCountry((String) obj[7]);
            officeDTO.setPostalCode((String) obj[8]);
            officeDTO.setPhoneNumber((String) obj[9]);
            employeeDTO.setOffice(officeDTO);
            return employeeDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findEmployeeAllNoOfficeNoClient() {
        List<Object[]> results = employeeRepository.findEmployeeAllNoOfficeNoClient();
        return results.stream().map(obj -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setName((String) obj[0]);
            employeeDTO.setSurname1((String) obj[1]);
            employeeDTO.setSurname2((String) obj[2]);
            employeeDTO.setExtension((String) obj[3]);
            employeeDTO.setEmail((String) obj[4]);
            employeeDTO.setPosition((String) obj[5]);
            return employeeDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findEmployeeAllNoClientWithBoss() {
        List<Object[]> results = employeeRepository.findEmployeeAllNoClientWithBoss();
        return results.stream().map(obj -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            EmployeeDTO bossDTO = new EmployeeDTO();
            employeeDTO.setEmployeeCode((Integer) obj[0]);
            employeeDTO.setName((String) obj[1]);
            employeeDTO.setSurname1((String) obj[2]);
            employeeDTO.setSurname2((String) obj[3]);
            employeeDTO.setEmail((String) obj[4]);
            employeeDTO.setExtension((String) obj[5]);
            employeeDTO.setPosition((String) obj[6]);
            bossDTO.setName((String) obj[7]);
            employeeDTO.setBoss(bossDTO);
            return employeeDTO;
        }).collect(Collectors.toList());
    }

}
