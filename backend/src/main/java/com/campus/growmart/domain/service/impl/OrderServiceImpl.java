package com.campus.growmart.domain.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.growmart.domain.repository.OrderRepository;
import com.campus.growmart.domain.service.OrderService;
import com.campus.growmart.persistence.dto.ClientDTO;
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

    @Override
    public List<OrderDTO> findOrdersNotOnTime() {
        List<Object[]> results = orderRepository.findOrdersNotOnTime();

        return results.stream().map(obj -> {
            OrderDTO orderDTO = new OrderDTO();
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientCode((Integer) obj[1]);
            orderDTO.setOrderCode((Integer) obj[0]);
            orderDTO.setClient(clientDTO);
            orderDTO.setExpectedDate((Date) obj[2]);
            orderDTO.setDeliveryDate((Date) obj[3]);
            return orderDTO;
        }).collect(Collectors.toList());

    }

    @Override
    public List<OrderDTO> findOrdersBeforeExpected() {
        List<Object[]> results = orderRepository.findOrdersBeforeExpected();

        return results.stream().map(obj -> {
            OrderDTO orderDTO = new OrderDTO();
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientCode((Integer) obj[1]);
            orderDTO.setOrderCode((Integer) obj[0]);
            orderDTO.setClient(clientDTO);
            orderDTO.setExpectedDate((Date) obj[2]);
            orderDTO.setDeliveryDate((Date) obj[3]);
            return orderDTO;
        }).collect(Collectors.toList());
        
    }

    

}
