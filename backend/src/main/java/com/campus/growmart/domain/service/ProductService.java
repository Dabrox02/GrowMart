package com.campus.growmart.domain.service;

import com.campus.growmart.persistence.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findProductRangeStock(String range, String stock);
    
}
