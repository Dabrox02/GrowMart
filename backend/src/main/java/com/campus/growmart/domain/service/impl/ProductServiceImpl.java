package com.campus.growmart.domain.service.impl;

import com.campus.growmart.domain.repository.ProductRepository;
import com.campus.growmart.persistence.dto.ProductDTO;
import com.campus.growmart.persistence.dto.ProductRangeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.service.ProductService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> findProductRangeStock(String range, String stock) {
        List<Object[]> results = productRepository.findProductRangeStock(range, stock);

        return results.stream().map(obj -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductCode((String) obj[0]);
            productDTO.setName((String) obj[1]);
            ProductRangeDTO productRangeDTO = new ProductRangeDTO();
            productRangeDTO.setRange((String) obj[2]);
            productDTO.setProductRange(productRangeDTO);
            productDTO.setStock((Short) obj[3]);
            productDTO.setSalePrice((BigDecimal) obj[4]);
            return productDTO;
        }).collect(Collectors.toList());

    }

    @Override
    public Map<String, Object> findMostExpesiveAndChespest() {
        List<Object[]> results = productRepository.findMostExpesiveAndChespest();
        Map<String, Object> mostExpensiveAndCheapest = new HashMap<>();
        results.stream().forEach(obj->{
            mostExpensiveAndCheapest.put("most_expensive_price", obj[0] );
            mostExpensiveAndCheapest.put("cheapest_price", obj[1] );
        });

        return mostExpensiveAndCheapest;
    }
}
