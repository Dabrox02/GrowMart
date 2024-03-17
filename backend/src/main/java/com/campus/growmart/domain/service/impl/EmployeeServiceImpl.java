package com.campus.growmart.domain.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.EmployeeRepository;
import com.campus.growmart.domain.service.EmployeeService;
import com.campus.growmart.persistence.dto.EmployeeDTO;
import com.campus.growmart.persistence.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

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
    public  Map<String, Object> count() {
        long results = employeeRepository.count();
        Map<String, Object> clientCount = new HashMap<>();
        clientCount.put("employee_amount", results);
        return clientCount;
    }

    @Override
    public List<Map<String, Object>> findEmployeeAmountClients() {
        List<Object[]> results = employeeRepository.findEmployeeAmountClients();
        List<Map<String, Object>> dataList = new ArrayList<>();

        results.stream().forEach( obj->{
            Map<String, Object> employeeAmountCLients = new HashMap<>();
            employeeAmountCLients.put("employee_name", obj[0]);
            employeeAmountCLients.put("client_amount", obj[1]);
            dataList.add(employeeAmountCLients);
        }  );

        return dataList;
    }

}
