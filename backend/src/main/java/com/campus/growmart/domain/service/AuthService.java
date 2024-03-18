package com.campus.growmart.domain.service;

import java.util.Map;

import com.campus.growmart.persistence.dto.UserSystemDTO;

public interface AuthService {

    UserSystemDTO login(String username, String password);

    UserSystemDTO register(String username, String password);

    Map<String, Object> validateToken(String token);
}
