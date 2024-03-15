package com.campus.growmart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.growmart.domain.service.OfficeService;
import com.campus.growmart.persistence.dto.OfficeDTO;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping("/officecode/city")
    public ResponseEntity<?> findAllOfficeCodesAndCities() {
        List<OfficeDTO> offices = officeService.findAllOfficeCodesAndCities();
        if (offices.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(offices);
    }

    @GetMapping("/country")
    public ResponseEntity<?> findByCountryLike(@RequestParam String country) {
        List<OfficeDTO> offices = officeService.findByCountryLike(country);
        if (offices.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(offices);
    }

    @GetMapping("/clients/city")
    public ResponseEntity<?> findOfficesWithClientsIn(@RequestParam String city) {
        List<OfficeDTO> offices = officeService.findOfficesWithClientsIn(city);
        if (offices.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(offices);
    }
}
