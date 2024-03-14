package com.campus.growmart.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.PaymentRepository;
import com.campus.growmart.domain.service.PaymentService;
import com.campus.growmart.persistence.dto.ClientDTO;
import com.campus.growmart.persistence.dto.PaymentDTO;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentDTO> findClientCodesPaymentYear(String year) {        
        List<Object> results = paymentRepository.findClientCodesPaymentYear(year);

        return results.stream().map( obj ->{
                PaymentDTO paymentDTO = new PaymentDTO();
                ClientDTO clientDTO = new ClientDTO();
                clientDTO.setClientCode((Integer) obj);
                paymentDTO.setClient(clientDTO);
                return paymentDTO;
            }
        ).collect(Collectors.toList());

    }

}
