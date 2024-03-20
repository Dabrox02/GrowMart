package com.campus.growmart.domain.service;

import java.util.List;
import java.util.Map;

import com.campus.growmart.persistence.dto.PaymentDTO;

public interface PaymentService {

    List<PaymentDTO> findClientCodesPaymentYear(String year);

    List<PaymentDTO> findPaymentsYearMethod(String method, String year);

    List<PaymentDTO> findDistinctByPaymentMethod();

    List<Map<String, Object>> findAveragePayment(String year);

    List<Map<String, Object>> findSumAllPaymentsYear();

}
