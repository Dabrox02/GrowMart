package com.campus.growmart.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.UserSystemRepository;
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

    @Override
    public UserSystemDTO login(String username, String password) {
        UserSystem user = userSystemRepository.findByUsername(username).orElse(null);
        if (user != null) {
            String token = jwtAuthtenticationConfig.getJWTToken(user.getUsername());
            UserSystemDTO userSystemDTO = new UserSystemDTO();
            userSystemDTO.setUsername(username);
            userSystemDTO.setToken(token);
            return userSystemDTO;
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

}
