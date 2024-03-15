package com.campus.growmart.web.controller;

import java.util.List;
import java.util.Map;

import com.campus.growmart.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.growmart.domain.service.ClientService;
import com.campus.growmart.persistence.dto.ClientDTO;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clientCountry")
    public ResponseEntity<?> findByCountryLike(@RequestParam String country) {
        List<ClientDTO> clients = clientService.findByCountryLike(country);
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/clientCityEmployee")
    public ResponseEntity<?> findDistinctByCityAndSalesRepresentativeEmployeeCode(@RequestParam String city, @RequestParam String employeeCode){

        Employee employee = new Employee();
        employee.setEmployeeCode(  Integer.parseInt(employeeCode) );

        List<ClientDTO> results = clientService.findDistinctByCityAndSalesRepresentativeEmployeeCode(city,employee);

        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/countByCountry")
    public ResponseEntity<?>  countByCountry( ) {
        Map<String, Long> results = clientService.countByCountry() ;
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }
    

}
