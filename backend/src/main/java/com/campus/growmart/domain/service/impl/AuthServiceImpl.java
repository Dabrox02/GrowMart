package com.campus.growmart.domain.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.UserSystemRepository;
import com.campus.growmart.domain.security.JWTAuthorizationFilter;
import com.campus.growmart.domain.security.JWTAuthtenticationConfig;
import com.campus.growmart.domain.service.AuthService;
import com.campus.growmart.persistence.dto.UserSystemDTO;
import com.campus.growmart.persistence.entity.RoleUser;
import com.campus.growmart.persistence.entity.UserSystem;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserSystemRepository userSystemRepository;

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Override
    public UserSystemDTO login(String username, String password) {
        UserSystem user = userSystemRepository.findByUsername(username).orElse(null);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                String token = jwtAuthtenticationConfig.getJWTToken(user.getUsername());
                UserSystemDTO userSystemDTO = new UserSystemDTO();
                userSystemDTO.setUsername(username);
                userSystemDTO.setToken(token);
                return userSystemDTO;
            }
        }
        return null;
    }

    @Override
    public UserSystemDTO register(String username, String password) {
        UserSystem userSystem = new UserSystem();
        userSystem.setUsername(username);
        userSystem.setPassword(passwordEncoder.encode(password));
        userSystem.setRoleUser(RoleUser.USER);
        UserSystem response = userSystemRepository.save(userSystem);
        if (response != null) {
            UserSystemDTO userSystemDTO = new UserSystemDTO();
            userSystemDTO.setUsername(response.getUsername());
            userSystemDTO.setToken(jwtAuthtenticationConfig.getJWTToken(response.getUsername()));
            return userSystemDTO;
        }
        return null;
    }

    @Override
    public Map<String, Object> validateToken(String token) {
        Boolean validAcces = false;
        Boolean isJWTValid = jwtAuthorizationFilter.isJWTValid(token);
        if (isJWTValid) {
            String username = jwtAuthorizationFilter.getClaims(token).getSubject();
            UserSystem user = userSystemRepository.findByUsername(username).orElse(null);
            if (user != null) {
                validAcces = true;
            }
        }
        Map<String, Object> responseToken = new HashMap<>();
        responseToken.put("isTokenValid", validAcces);
        return responseToken;
    }

}
