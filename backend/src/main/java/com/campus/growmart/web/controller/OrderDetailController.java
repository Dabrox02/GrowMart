package com.campus.growmart.web.controller;

import com.campus.growmart.domain.repository.OrderDetailRepository;
import com.campus.growmart.domain.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/amountDistinctProductsInOrder")
    public ResponseEntity<?> amountDistinctProductsInOrder(){
        List<Map<String, Object>> results = orderDetailService.amountDistinctProductsInOrder();
        if(results.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);

    }

    @GetMapping("/amountProductsInOrder")
    public ResponseEntity<?> amountProductsInOrder(){
        List<Map<String, Object>> results = orderDetailService.amountProductsInOrder();
        if(results.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);

    }
    @GetMapping("/findBestSellingProductsLimit")
    public ResponseEntity<?> findBestSellingProducts(@RequestParam String limit){
        List<Map<String, Object>> results = orderDetailService.findBestSellingProducts(Integer.valueOf(limit));
        if(results.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }
    @GetMapping("/companyBilling")
    public ResponseEntity<?> findCompanyBilling(){
        List<Map<String, Object>> results = orderDetailService.findCompanyBilling();
        if(results.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/companyBillingProductCode")
    public ResponseEntity<?> findCompanyBillingProductCode(){
        List<Map<String, Object>> results = orderDetailService.findCompanyBillingProductCode();
        if(results.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/companyBillingProductCodeBeginsWith")
    public ResponseEntity<?> findCompanyBillingProductCodeBeginsWith(@RequestParam String beginsWith){
        List<Map<String, Object>> results = orderDetailService.findCompanyBillingProductCodeBeginsWith(beginsWith);
        if(results.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/productsBillingMoreThan")
    public ResponseEntity<?> findProductsBillingMoreThan( @RequestParam String moreThan ){
        List<Map<String, Object>> results = orderDetailService.findProductsBillingMoreThan(moreThan);
        if(results.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(results);
    }

}
