package com.campus.growmart.domain.service.impl;

import java.util.*;
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

    public List<OrderDTO> findOrdersrejectedYear(String year) {
        List<Object[]> results = orderRepository.findOrdersRejectedYear(year);

        return results.stream().map(obj -> {
            OrderDTO orderDTO = new OrderDTO();
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientCode((Integer) obj[1]);
            orderDTO.setOrderCode((Integer) obj[0]);
            orderDTO.setClient(clientDTO);
            orderDTO.setExpectedDate((Date) obj[2]);
            orderDTO.setDeliveryDate((Date) obj[3]);
            orderDTO.setState((String) obj[4]);
            return orderDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> findOrdersdeliveredMonth(String month) {
        List<Object[]> results = orderRepository.findOrdersDeliveredMonth(month);

        return results.stream().map(obj -> {
            OrderDTO orderDTO = new OrderDTO();
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientCode((Integer) obj[1]);
            orderDTO.setOrderCode((Integer) obj[0]);
            orderDTO.setClient(clientDTO);
            orderDTO.setExpectedDate((Date) obj[2]);
            orderDTO.setDeliveryDate((Date) obj[3]);
            orderDTO.setState((String) obj[4]);
            return orderDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> findOrdersPerState() {
        List<Object[]> results = orderRepository.findOrdersPerState();
        List<Map<String, Object>> dataList = new ArrayList<>();

        results.stream().forEach(  obj ->{

            Map<String, Object> ordersPerState = new HashMap<>();
            ordersPerState.put( "state", (String) obj[0] );
            ordersPerState.put( "orders_amount", (Long) obj[1] );
            dataList.add(ordersPerState);

        });
        return dataList;
    }

}
