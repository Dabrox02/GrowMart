package com.campus.growmart.domain.service;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {

    List<Map<String, Object>> amountDistinctProductsInOrder();
    List<Map<String, Object>> amountProductsInOrder();

    List<Map<String, Object>> findBestSellingProducts(int limit);
    List<Map<String, Object>> findCompanyBilling();
    List<Map<String, Object>> findCompanyBillingProductCode();
    List<Map<String, Object>> findCompanyBillingProductCodeBeginsWith(String beginsWith);
    List<Map<String, Object>> findProductsBillingMoreThan(String moreThan);
}
