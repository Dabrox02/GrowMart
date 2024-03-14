package com.campus.growmart.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.OfficeRepository;
import com.campus.growmart.domain.service.OfficeService;
import com.campus.growmart.persistence.dto.OfficeDTO;
import com.campus.growmart.persistence.entity.Office;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public List<OfficeDTO> findAllOfficeCodesAndCities() {
        List<Object[]> results = officeRepository.findOfficeCodesAndCities();

        return results.stream()
                .map(row -> {
                    OfficeDTO officeDTO = new OfficeDTO();
                    officeDTO.setOfficeCode((String) row[0]);
                    officeDTO.setCity((String) row[1]);
                    return officeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<OfficeDTO> findByCountryLike(String country) {
        List<Object> results = officeRepository.findByCountryIgnoreCase(country);

        return results.stream()
                .map(obj -> {
                    Office office = (Office) obj;
                    OfficeDTO officeDTO = new OfficeDTO();
                    officeDTO.setCity(office.getCity());
                    officeDTO.setPhoneNumber(office.getPhoneNumber());
                    return officeDTO;
                })
                .collect(Collectors.toList());
    }

}
