package com.campus.growmart.domain.service;

import com.campus.growmart.persistence.dto.UserSystemDTO;

public interface AuthService {

    UserSystemDTO login(String username, String password);

    UserSystemDTO register(String username, String password);

}
