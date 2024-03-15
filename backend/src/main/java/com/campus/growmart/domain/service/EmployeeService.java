package com.campus.growmart.domain.service;

import java.util.List;
import java.util.Map;

import com.campus.growmart.persistence.dto.EmployeeDTO;

public interface EmployeeService {

    List<EmployeeDTO> findNameLastnameByCodeBoss(Integer bossCode);

    List<EmployeeDTO> findBossCompany();

    List<EmployeeDTO> findNameLastnamePositionNotLike(String position);

    Map<String, Object> count();

    List<Map<String, Object>> findEmployeeAmountClients();

    List<EmployeeDTO> findNameClientWithSalesRep();

    List<EmployeeDTO> findNameEmployeeWithNameBoss();

    List<EmployeeDTO> findEmployeeWithBossWithBoss();
}
