package com.campus.growmart.web.controller;

import java.util.List;

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

    @GetMapping("/not/position")
    public ResponseEntity<?> findNameLastnamePositionNotLike(@RequestParam String position) {
        List<EmployeeDTO> employees = employeeService.findNameLastnamePositionNotLike(position);
        if (employees.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping("/count")
    public ResponseEntity<?>  count() {
        long results = employeeService.count();
        return ResponseEntity.ok().body(results);
        
    }
    

}
