package com.campus.growmart.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.growmart.domain.service.AuthService;
import com.campus.growmart.persistence.dto.UserSystemDTO;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        UserSystemDTO userSystemDTO = authService.login(username, password);

        if (userSystemDTO == null) {
            throw new UsernameNotFoundException("User Not exists");
        }
        return ResponseEntity.ok().body(userSystemDTO);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        UserSystemDTO userSystemDTO = authService.register(username, password);
        if (userSystemDTO == null) {
            throw new Error("Cannot created user");
        }
        return ResponseEntity.ok(userSystemDTO);
    }

    @PostMapping("validateToken")
    public ResponseEntity<?> validateToken(
            @RequestParam("token") String token) {
        Map<String, Object> validToken = authService.validateToken(token);
        return ResponseEntity.ok(validToken);
    }

}