package com.campus.growmart.web.controller;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> findClientByCityAndEmployeeCode(@RequestParam String city, @RequestParam String employeeCode, @RequestParam String employeeCode2){
        List<ClientDTO> results = clientService.findClientByCityAndEmployeeCode(city,employeeCode, employeeCode2);

        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/countByCountry")
    public ResponseEntity<?>  countByCountry( ) {
        List<Map<String, Object>> results = clientService.countByCountry() ;
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/countClientsAmount")
    public ResponseEntity<?> count(){
        Map<String, Object> results = clientService.count();
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }


    @GetMapping("/countClientsAmountCity")
    public ResponseEntity<?> countByCity(@RequestParam String city){
        Map<String, Object> results = clientService.countByCity(city);
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }


    @GetMapping("/countClientsCityBeginWith")
    public ResponseEntity<?> countClientsCityBeginWith(@RequestParam String initialLetterCity){
        List<Map<String, Object>> results = clientService.countClientsCityBeginWith(initialLetterCity);
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);

    }
    @GetMapping("/countClientsWithoutEmployee")
    public ResponseEntity<?> clientAmountWithoutEmployee(){
        Map<String, Object> results = clientService.clientAmountWithoutEmployee();
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/clientFirstLastPayment")
    public ResponseEntity<?> clientFirstLastPayment(){
        List<Map<String, Object>> results = clientService.clientFirstLastPayment();
        if (results.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(results);
    }
    @GetMapping("/paid")
    public ResponseEntity<?> findClientsWithPayment() {
        List<ClientDTO> clients = clientService.findClientsWithPayment();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/noPaid")
    public ResponseEntity<?> findClientsWithNoPayment() {
        List<ClientDTO> clients = clientService.findClientsWithNoPayment();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/office/paid")
    public ResponseEntity<?> findClientsOfficeWithPayment() {
        List<ClientDTO> clients = clientService.findClientsOfficeWithPayment();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/office/nopaid")
    public ResponseEntity<?> findClientsOfficeWithNoPayment() {
        List<ClientDTO> clients = clientService.findClientsOfficeWithNoPayment();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/salesRep/office")
    public ResponseEntity<?> findClientWithSalesRepAndOffice() {
        List<ClientDTO> clients = clientService.findClientWithSalesRepAndOffice();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/order/notInTime")
    public ResponseEntity<?> findClientOrderNotInTime() {
        List<ClientDTO> clients = clientService.findClientOrderNotInTime();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/productRange/purchased")
    public ResponseEntity<?> findClientProductRangePurchased() {
        List<ClientDTO> clients = clientService.findClientProductRangePurchased();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/noPaid/all")
    public ResponseEntity<?> findClientAllWithNoPayment() {
        List<ClientDTO> clients = clientService.findClientAllWithNoPayment();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/noOrder/all")
    public ResponseEntity<?> findClientAllWithNoOrder() {
        List<ClientDTO> clients = clientService.findClientAllWithNoOrder();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping("/noPaid/noOrder/all")
    public ResponseEntity<?> findClientAllWithNoPaidNoOrder() {
        List<ClientDTO> clients = clientService.findClientAllWithNoPaidNoOrder();
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }
}
