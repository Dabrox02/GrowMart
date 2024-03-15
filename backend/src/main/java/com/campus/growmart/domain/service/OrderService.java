package com.campus.growmart.domain.service;

import java.util.List;

import com.campus.growmart.persistence.dto.OrderDTO;

public interface OrderService {
    
    List<OrderDTO> findStatesOrder();
    List<OrderDTO> findOrdersNotOnTime();
    List<OrderDTO> findOrdersBeforeExpected();
    List<OrderDTO> findOrdersrejectedYear(String year);

    List<OrderDTO> findOrdersdeliveredMonth(String month);

}
