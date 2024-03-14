package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Devulve un listado con los distintos estados por los que puede pasar un pedido.
    @Query("SELECT DISTINCT o.state FROM Order o GROUP BY o.state")
    List<Object> findStatesOrder();

    // Devuelve un listado con el codigo de pedido, codigo de cliente, fecha esperada y fecha de entrega de los pedidos que no han sido entregados a tiempo.
    @Query("SELECT  o.orderCode, o.client.clientCode  , o.expectedDate, o.deliveryDate FROM Order o WHERE o.deliveryDate > o.expectedDate")
    List<Object[]> findOrdersNotOnTime();

    // Devuelve un listado con el código de pedido, código de cliente, fecha esperada y fecha de entrega de los pedidos cuya fecha de entrega ha sido al menos dos días antes de la fecha esperada.
    @Query("SELECT o.orderCode, o.client.clientCode, o.expectedDate, o.deliveryDate FROM Order o WHERE (o.deliveryDate - o.expectedDate) <= -2")
    List<Object[]> findOrdersBeforeExpected();
}
