package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {

    // Devuelve un listado con el código de oficina y la ciudad donde hay oficinas.
    @Query("SELECT o.officeCode, o.city FROM Office o")
    List<Object[]> findOfficeCodesAndCities();

    // Devuelve un listado con la ciudad y el teléfono de las oficinas de España.
    List<Object> findByCountryIgnoreCase(String country);

    // Lista la dirección de las oficinas que tengan clientes en Fuenlabrada.
    @Query(value = "SELECT DISTINCT ofi.linea_direccion1 FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina ofi ON e.codigo_oficina = ofi.codigo_oficina WHERE LOWER(c.ciudad) = LOWER(?1)", nativeQuery = true)
    List<Object[]> findOfficesWithClientsIn(String city);

    // Devuelve las oficinas donde no trabajan ninguno de los empleados que hayan
    // sido los representantes de ventas de algún cliente que haya realizado la
    // compra de algún producto de la gama Frutales.
    @Query(value = "SELECT DISTINCT ofi FROM Office ofi LEFT JOIN ofi.employeeList em JOIN em.clientList cl JOIN cl.orderList or JOIN or.orderDetailList det JOIN det.product pro WHERE LOWER(pro.productRange.range) != LOWER(?1)")
    List<Object> findOfficesNoSalesRepsOf(String productRange);

}
