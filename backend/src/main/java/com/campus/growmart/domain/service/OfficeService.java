package com.campus.growmart.domain.service;

import java.util.List;

import com.campus.growmart.persistence.dto.OfficeDTO;

public interface OfficeService {

    List<OfficeDTO> findAllOfficeCodesAndCities();

    List<OfficeDTO> findByCountryLike(String country);

    List<OfficeDTO> findOfficesWithClientsIn(String city);
    

}
