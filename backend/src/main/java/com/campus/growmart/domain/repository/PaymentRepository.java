package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Object> {

    // Devuelve un listado con el código de cliente de aquellos clientes que
    // realizaron algun pago en 2008. Tenga en cuenta que debera eliminar aquellos
    // codigos de cliente que aparezcan repetidos.
    @Query("SELECT DISTINCT p.client.clientCode FROM Payment p WHERE YEAR(p.paymentDate) = ?1")
    List<Object> findClientCodesPaymentYear(String year);

    // Devuelve un listado con todos los pagos que se realizaron en el año 2009
    // mediante Paypal. Ordene el resultado de mayor a menor.
    @Query("SELECT p.client.clientCode , p.paymentMethod, p.transactionId, p.paymentDate, p.total FROM Payment p WHERE LOWER(p.paymentMethod) = LOWER(?1) AND YEAR(p.paymentDate) = ?2 ORDER BY p.total")
    List<Object[]> findPaymentsYearMethod(String method, String year);

    // Devuelve un listado con todas las formas de pago que aparecen en la
    // tabla pago. Tenga en cuenta que no deben aparecer formas de pago repetidas.
    @Query("SELECT DISTINCT p.paymentMethod FROM Payment p")
    List<Object> findDistinctByPaymentMethod();

    // ¿Cuál fue el pago medio en 2009?
    @Query("SELECT AVG(p.total), YEAR(p.paymentDate) FROM Payment p WHERE YEAR(p.paymentDate) = ?1")
    List<Object[]> findAveragePayment(String year);

    // Muestre la suma total de todos los pagos que se realizaron para cada uno de
    // los años que aparecen en la tabla pagos.
    @Query("SELECT YEAR(p.paymentDate), SUM(p.total) FROM Payment p GROUP BY YEAR(p.paymentDate) ORDER BY YEAR(p.paymentDate)")
    List<Object[]> findSumAllPaymentsYear();

}
