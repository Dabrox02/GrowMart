package com.campus.growmart.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.growmart.domain.service.PaymentService;
import com.campus.growmart.persistence.dto.PaymentDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/payment")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/clientCodes")
    public ResponseEntity<?> findClientCodesPaymentYear(@RequestParam String year) {
        List<PaymentDTO> results = paymentService.findClientCodesPaymentYear(year);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/paymentMethodYear")
    public ResponseEntity<?> findPaymentsYearMethod(@RequestParam String method, @RequestParam String year) {

        List<PaymentDTO> results = paymentService.findPaymentsYearMethod(method, year);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/allPaymentMethods")
    public ResponseEntity<?> findDistincPaymentMethod() {
        List<PaymentDTO> results = paymentService.findDistinctByPaymentMethod();
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/averagePaymentYear")
    public ResponseEntity<?> findAveragePayment(@RequestParam String year) {

        List<Map<String, Object>> results = paymentService.findAveragePayment(year);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/sumAllPaymentsYear")
    public ResponseEntity<?> findSumAllPaymentsYear() {
        List<Map<String, Object>> results = paymentService.findSumAllPaymentsYear();
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }
}
