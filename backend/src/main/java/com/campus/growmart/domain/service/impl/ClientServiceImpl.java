package com.campus.growmart.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.ClientRepository;
import com.campus.growmart.domain.service.ClientService;
import com.campus.growmart.persistence.dto.ClientDTO;
import com.campus.growmart.persistence.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> findByCountryLike(String country) {
        List<Object> results = clientRepository.findByCountryLike(country);

        return results.stream()
                .map(obj -> {
                    Client client = (Client) obj;
                    ClientDTO clientDTO = new ClientDTO();
                    clientDTO.setClientName(client.getClientName());
                    return clientDTO;
                }).collect(Collectors.toList());

    }

}
