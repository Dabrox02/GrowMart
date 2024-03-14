package com.campus.growmart.domain.service;

import java.util.List;

import com.campus.growmart.persistence.dto.ClientDTO;

public interface ClientService {

    List<ClientDTO> findByCountryLike(String country);
    
}
