package com.campus.growmart.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.growmart.domain.service.EmployeeService;
import com.campus.growmart.persistence.dto.EmployeeDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/name/surnames")
    public ResponseEntity<?> findNameLastnameByCodeBoss(@RequestParam String codeBoss) {
        try {
            Integer code = Integer.parseInt(codeBoss);

            List<EmployeeDTO> employees = employeeService.findNameLastnameByCodeBoss(code);
            if (employees.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok().body(employees);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Código de jefe inválido: " + codeBoss);
        }
    }

    @GetMapping("/boss")
    public ResponseEntity<?> findBossCompany() {
        List<EmployeeDTO> employees = employeeService.findBossCompany();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/noPosition")
    public ResponseEntity<?> findNameLastnamePositionNotLike(@RequestParam String position) {
        List<EmployeeDTO> employees = employeeService.findNameLastnamePositionNotLike(position);
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/countEmployeesAmount")
    public ResponseEntity<?>  count() {
        Map<String, Object> results = employeeService.count();
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/employeeAmountClients")
    public ResponseEntity<?> findEmployeeAmountClients(){
        List<Map<String, Object>> results = employeeService.findEmployeeAmountClients();
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }


    @GetMapping("/clients")
    public ResponseEntity<?> findNameClientWithSalesRep() {
        List<EmployeeDTO> employees = employeeService.findNameClientWithSalesRep();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/with/boss")
    public ResponseEntity<?> findNameEmployeeWithNameBoss() {
        List<EmployeeDTO> employees = employeeService.findNameEmployeeWithNameBoss();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/with/boss/boss")
    public ResponseEntity<?> findEmployeeWithBossWithBoss() {
        List<EmployeeDTO> employees = employeeService.findEmployeeWithBossWithBoss();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/noOffice/all")
    public ResponseEntity<?> findEmployeeAllNoOffice() {
        List<EmployeeDTO> employees = employeeService.findEmployeeAllNoOffice();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/noClient/all")
    public ResponseEntity<?> findEmployeeAllNoClient() {
        List<EmployeeDTO> employees = employeeService.findEmployeeAllNoClient();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/noClient/office/all")
    public ResponseEntity<?> findEmployeeOfficeNoClient() {
        List<EmployeeDTO> employees = employeeService.findEmployeeOfficeNoClient();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/noClient/noOffice/all")
    public ResponseEntity<?> findEmployeeAllNoOfficeNoClient() {
        List<EmployeeDTO> employees = employeeService.findEmployeeAllNoOfficeNoClient();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/noClient/with/boss/all")
    public ResponseEntity<?> findEmployeeAllNoClientWithBoss() {
        List<EmployeeDTO> employees = employeeService.findEmployeeAllNoClientWithBoss();
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

}
