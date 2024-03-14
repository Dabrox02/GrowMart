package com.campus.growmart.web.controller;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<?> findByCountryLike(@RequestParam String country) {
        List<ClientDTO> clients = clientService.findByCountryLike(country);
        if (clients.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(clients);
    }

}
