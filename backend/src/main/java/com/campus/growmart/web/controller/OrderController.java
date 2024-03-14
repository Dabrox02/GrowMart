package com.campus.growmart.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
