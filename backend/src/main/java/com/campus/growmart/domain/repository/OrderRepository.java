package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Devulve un listado con los distintos estados por los que puede pasar un pedido.
    @Query("SELECT DISTINCT o.state FROM Order o GROUP BY o.state")
    List<Object> findStatesOrder();

}
