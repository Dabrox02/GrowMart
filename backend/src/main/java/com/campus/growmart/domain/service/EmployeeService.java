package com.campus.growmart.domain.service;

import java.util.List;

import com.campus.growmart.persistence.dto.EmployeeDTO;

public interface EmployeeService {

    List<EmployeeDTO> findNameLastnameByCodeBoss(Integer bossCode);

    List<EmployeeDTO> findBossCompany();

    List<EmployeeDTO> findNameLastnamePositionNotLike(String position);

    long count();

}
