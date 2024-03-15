package com.campus.growmart.web.controller;

import com.campus.growmart.domain.service.ProductService;
import com.campus.growmart.persistence.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productsRangePrice")
    public ResponseEntity<?> findProductRangeStock(@RequestParam String range, @RequestParam String stock) {
        List<ProductDTO> results = productService.findProductRangeStock(range, stock);
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

}
