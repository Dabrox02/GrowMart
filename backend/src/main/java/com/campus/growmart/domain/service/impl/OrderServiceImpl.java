package com.campus.growmart.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.OrderRepository;
import com.campus.growmart.domain.service.OrderService;
import com.campus.growmart.persistence.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> findStatesOrder() {
        List<Object> results = orderRepository.findStatesOrder();
        return results.stream().map(obj -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setState((String) obj);
            return orderDTO;
        }).collect(Collectors.toList());

    }

}
