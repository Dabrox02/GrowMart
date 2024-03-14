package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Object> {

    // Devuelve un listado con el código de cliente de aquellos clientes que realizaron algun pago en 2008. Tenga en cuenta que debera eliminar aquellos codigos de cliente que aparezcan repetidos.

    @Query("SELECT DISTINCT p.client.clientCode FROM Payment p WHERE YEAR(p.paymentDate) = ?1")
    List<Object> findClientCodesPaymentYear(String year);


}
