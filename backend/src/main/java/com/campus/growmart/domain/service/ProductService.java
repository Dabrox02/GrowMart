package com.campus.growmart.domain.service;

import com.campus.growmart.persistence.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<ProductDTO> findProductRangeStock(String range, String stock);

    List<Map<String, Object>> findMostExpesiveAndChespest();

    List<ProductDTO> findProductNoOrder();

    List<ProductDTO> findProductNoOrderAll();

}
