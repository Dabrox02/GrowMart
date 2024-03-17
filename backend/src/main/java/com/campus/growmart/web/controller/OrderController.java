package com.campus.growmart.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.growmart.domain.service.OrderService;
import com.campus.growmart.persistence.dto.OrderDTO;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/states")
    public ResponseEntity<?> findStatesOrder() {
        List<OrderDTO> states = orderService.findStatesOrder();
        if (states.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(states);
    }

    @GetMapping("/notInTime")
    public ResponseEntity<?> findOrdersNotOnTime() {
        List<OrderDTO> results = orderService.findOrdersNotOnTime();
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/beforeExpected")
    public ResponseEntity<?> findOrdersBeforeExpected() {
        List<OrderDTO> results = orderService.findOrdersBeforeExpected();
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/rejectedYear")
    public ResponseEntity<?> findOrdersrejectedYear(@RequestParam String year) {
        List<OrderDTO> results = orderService.findOrdersrejectedYear(year);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/deliveredMonth")
    public ResponseEntity<?> findOrdersdeliveredMonth(@RequestParam String month) {
        List<OrderDTO> results = orderService.findOrdersdeliveredMonth(month);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/ordersPerState")
    public ResponseEntity<?> findOrdersPerState(){
        List<Map<String, Object>> results = orderService.findOrdersPerState();
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

}
