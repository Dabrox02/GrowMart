package com.campus.growmart.domain.service.impl;

import com.campus.growmart.domain.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.service.OrderDetailService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Map<String, Object>> amountDistinctProductsInOrder() {
        List<Object[]> results = orderDetailRepository.amountDistinctProductsInOrder();
        List<Map<String, Object>> dataList = new ArrayList<>();

        results.stream().forEach( obj -> {
            Map<String, Object> distinctProductsInOrder  = new HashMap<>();
            distinctProductsInOrder.put("order_code", obj[0]);
            distinctProductsInOrder.put("amount_distinct_products", obj[1]);
            dataList.add(distinctProductsInOrder);
        });
        return dataList;
    }

    @Override
    public List<Map<String, Object>> amountProductsInOrder() {
        List<Object[]> results = orderDetailRepository.amountProductsInOrder();
        List<Map<String, Object>> dataList = new ArrayList<>();

        results.stream().forEach( obj -> {
            Map<String, Object> productsInOrder  = new HashMap<>();
            productsInOrder.put("order_code", obj[0]);
            productsInOrder.put("amount_products", obj[1]);
            dataList.add(productsInOrder);
        });
        return dataList;
    }

    @Override
    public List<Map<String, Object>> findBestSellingProducts(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        List<Object[]> results = orderDetailRepository.findBestSellingProducts(pageable);
        List<Map<String, Object>> dataList = new ArrayList<>();
        results.stream().forEach( obj -> {
            Map<String, Object> bestSellingProduct  = new HashMap<>();
            bestSellingProduct.put("product_name", obj[0]);
            bestSellingProduct.put("amount_sold", obj[1]);
            dataList.add(bestSellingProduct);
        });
        return dataList;
    }

    @Override
    public List<Map<String, Object>> findCompanyBilling() {
        List<Object[]> results = orderDetailRepository.findCompanyBilling();
        List<Map<String, Object>> dataList = new ArrayList<>();

        results.stream().forEach(obj ->{
            Map<String, Object> companyBilling  = new HashMap<>();
            companyBilling.put("taxable_base", obj[0]);
            companyBilling.put("total_value_added_tax", obj[1]);
            companyBilling.put("total_billed", obj[2]);
            dataList.add(companyBilling);
        });
        return dataList;
    }

    @Override
    public List<Map<String, Object>> findCompanyBillingProductCode() {
        List<Object[]> results = orderDetailRepository.findCompanyBillingProductCode();
        List<Map<String, Object>> dataList = new ArrayList<>();
        results.stream().forEach(obj ->{
            Map<String, Object> companyBillingProductCode  = new HashMap<>();
            companyBillingProductCode.put("product_code", obj[0]);
            companyBillingProductCode.put("taxable_base_product", obj[1]);
            companyBillingProductCode.put("total_value_added_tax_product", obj[2]);
            companyBillingProductCode.put("total_billed_product", obj[3]);
            dataList.add(companyBillingProductCode);
        });
        return dataList;
    }

    @Override
    public List<Map<String, Object>> findCompanyBillingProductCodeBeginsWith(String beginsWith) {
        List<Object[]> results = orderDetailRepository.findCompanyBillingProductCodeBeginsWith(beginsWith);
        List<Map<String, Object>> dataList = new ArrayList<>();
        results.stream().forEach(obj ->{
            Map<String, Object> companyBillingProductCodeBeginsWith  = new HashMap<>();
            companyBillingProductCodeBeginsWith.put("product_code", obj[0]);
            companyBillingProductCodeBeginsWith.put("taxable_base_product", obj[1]);
            companyBillingProductCodeBeginsWith.put("total_value_added_tax_product", obj[2]);
            companyBillingProductCodeBeginsWith.put("total_billed_product", obj[3]);
            dataList.add(companyBillingProductCodeBeginsWith);
        });
        return dataList;
    }

    @Override
    public List<Map<String, Object>> findProductsBillingMoreThan(String moreThan) {
        List<Object[]> results = orderDetailRepository.findProductsBillingMoreThan(moreThan);
        List<Map<String, Object>>  dataList = new ArrayList<>();
        results.stream().forEach(obj->{
            Map<String, Object> productosBillongMoreThan  = new HashMap<>();
            productosBillongMoreThan.put("product_name", obj[0]);
            productosBillongMoreThan.put("sold_units", obj[1]);
            productosBillongMoreThan.put("total_billed", obj[2]);
            productosBillongMoreThan.put("total_billed_with_taxes", obj[3]);
            dataList.add(productosBillongMoreThan);
        });
        return dataList;
    }
}
