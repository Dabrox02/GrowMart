package com.campus.growmart.domain.service;

import java.util.List;

import com.campus.growmart.persistence.dto.PaymentDTO;

public interface PaymentService {

    List<PaymentDTO> findClientCodesPaymentYear(String year) ;

    List<PaymentDTO> findPaymentsYearMethod(String method, String year );

    List<PaymentDTO> findDistinctByPaymentMethod();

}
