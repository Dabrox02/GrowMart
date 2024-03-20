package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Client;
import com.campus.growmart.persistence.entity.Employee;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Devuelve un listado con el nombre de los todos los clientes españoles.
    List<Object> findByCountryIgnoreCase(String country);

    // Obtén un listado con el nombre de cada cliente y el nombre y apellido de su
    // representante de ventas.
    @Query(value = "SELECT c.nombre_cliente, e.codigo_empleado, e.nombre, e.apellido1, e.apellido2 FROM cliente c, empleado e WHERE c.codigo_empleado_rep_ventas = e.codigo_empleado", nativeQuery = true)
    List<Object[]> findNameClientWithSalesRep();

    // Muestra el nombre de los clientes que hayan realizado pagos junto con el
    // nombre de sus representantes de ventas.
    @Query(value = "SELECT DISTINCT c.nombre_cliente, e.nombre, e.apellido1 as Representante FROM cliente c, empleado e, pago p WHERE c.codigo_empleado_rep_ventas = e.codigo_empleado AND p.codigo_cliente = c.codigo_cliente;", nativeQuery = true)
    List<Object[]> findClientsWithPayment();

    // Muestra el nombre de los clientes que no hayan realizado pagos junto con el
    // nombre de sus representantes de ventas.
    @Query(value = "SELECT c.nombre_cliente, e.nombre, e.apellido1 as Representante FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente WHERE p.codigo_cliente IS NULL", nativeQuery = true)
    List<Object[]> findClientsWithNoPayment();

    // Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y
    // cuyo representante de ventas tenga el código de empleado 11 o 30.
    @Query("SELECT c.clientCode, c.clientName, c.salesRepresentativeEmployeeCode.employeeCode, c.city  FROM Client c WHERE LOWER(c.city) = LOWER(?1) AND c.salesRepresentativeEmployeeCode.employeeCode IN (?2, ?3)")
    List<Object[]> findClientByCityAndEmployeeCode(String city, String employeeCode1, String employeeCode2);

    // ¿Cuántos clientes tiene cada país?
    @Query("select  c.country ,count(c.country) as client_number from Client c group by c.country")
    List<Object[]> countByCountry();

    // Calcula el número de clientes que tiene la empresa.
    long count();

    // ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
    long countByCityIgnoreCase(String city);

    // ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por
    // 'M'?
    @Query("SELECT COUNT(c) , c.city FROM Client c group by c.city  HAVING LOWER(c.city) LIKE LOWER(:initialLetterCity) || '%'")
    List<Object[]> countClientsCityBeginWith(@Param("initialLetterCity") String initialLetterCity);

    // Calcula el número de clientes que no tiene asignado representante de ventas.
    @Query("SELECT COUNT(*) FROM Client c WHERE c.salesRepresentativeEmployeeCode IS NULL")
    List<Object[]> clientAmountWithoutEmployee();

    // Calcula la fecha del primer y último pago realizado por cada uno de los
    // clientes. El listado deberá mostrar el nombre y los apellidos de cada
    // cliente.
    @Query("SELECT c.clientName, c.contactName, c.contactSurname, MIN(pg.paymentDate) , MAX(pg.paymentDate)  FROM Client c LEFT JOIN c.paymentList pg  GROUP BY c.clientName, c.contactName, c.contactSurname")
    List<Object[]> clientFirstLastPayment();

    // Devuelve el nombre de los clientes que han hecho pagos y el nombre de sus
    // representantes junto con la ciudad de la oficina a la que pertenece el
    // representante.
    @Query(value = "SELECT DISTINCT c.nombre_cliente, e.nombre, e.apellido1, ofi.ciudad FROM cliente c JOIN pago p ON c.codigo_cliente = p.codigo_cliente JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina ofi ON e.codigo_oficina = ofi.codigo_oficina", nativeQuery = true)
    List<Object[]> findClientsOfficeWithPayment();

    // Devuelve el nombre de los clientes que no hayan hecho pagos y el nombre de
    // sus representantes junto con la ciudad de la oficina a la que pertenece el
    // representante.
    @Query(value = "SELECT c.nombre_cliente, e.nombre, e.apellido1, ofi.ciudad FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina ofi ON e.codigo_oficina = ofi.codigo_oficina LEFT JOIN pago p ON c.codigo_cliente = p.codigo_cliente WHERE p.codigo_cliente IS NULL", nativeQuery = true)
    List<Object[]> findClientsOfficeWithNoPayment();

    // Devuelve el nombre de los clientes y el nombre de sus representantes junto
    // con la ciudad de la oficina a la que pertenece el representante.
    @Query(value = "SELECT DISTINCT c.nombre_cliente, e.nombre, e.apellido1, ofi.ciudad FROM cliente c JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado JOIN oficina ofi ON e.codigo_oficina = ofi.codigo_oficina", nativeQuery = true)
    List<Object[]> findClientWithSalesRepAndOffice();

    // Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo
    // un pedido.
    @Query(value = "SELECT DISTINCT c.nombre_cliente FROM cliente c INNER JOIN pedido p ON c.codigo_cliente = p.codigo_cliente WHERE p.fecha_entrega > p.fecha_esperada", nativeQuery = true)
    List<Object[]> findClientOrderNotInTime();

    // Devuelve un listado de las diferentes gamas de producto que ha comprado cada
    // cliente.
    @Query(value = "SELECT DISTINCT ped.codigo_cliente, p.gama AS Gama FROM producto p JOIN detalle_pedido dp ON p.codigo_producto = dp.codigo_producto JOIN pedido ped ON dp.codigo_pedido = ped.codigo_pedido JOIN pago pg ON pg.codigo_cliente = ped.codigo_cliente", nativeQuery = true)
    List<Object[]> findClientProductRangePurchased();

    // Devuelve un listado que muestre solamente los clientes que no han pagado.
    @Query(value = "SELECT codigo_cliente, limite_credito,codigo_postal,fax,telefono,apellido_contacto,nombre_contacto,ciudad,linea_direccion1,linea_direccion2,nombre_cliente,pais,region FROM cliente WHERE codigo_cliente NOT IN (select codigo_cliente FROM pago)", nativeQuery = true)
    List<Object[]> findClientAllWithNoPayment();

    // Devuelve un listado que muestre solamente los clientes que no han realizado
    // ningún pedido.
    @Query(value = "SELECT c.codigo_cliente, c.limite_credito,c.codigo_postal,c.fax,c.telefono,c.apellido_contacto,c.nombre_contacto,c.ciudad,c.linea_direccion1,c.linea_direccion2,c.nombre_cliente,c.pais,c.region FROM cliente c LEFT JOIN pedido p ON c.codigo_cliente = p.codigo_cliente WHERE p.codigo_cliente IS NUll", nativeQuery = true)
    List<Object[]> findClientAllWithNoOrder();

    // Devuelve un listado que muestre los clientes que no han realizado ningún pago
    // y los que no han realizado ningún pedido.
    @Query(value = "SELECT c.codigo_cliente, c.limite_credito,c.codigo_postal,c.fax,c.telefono,c.apellido_contacto,c.nombre_contacto,c.ciudad,c.linea_direccion1,c.linea_direccion2,c.nombre_cliente,c.pais,c.region FROM cliente c LEFT JOIN pedido p ON c.codigo_cliente = p.codigo_cliente WHERE p.codigo_cliente IS NUll", nativeQuery = true)
    List<Object[]> findClientAllWithNoPaidNoOrder();

    // Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y
    // cuyo representante de ventas tenga el código de empleado 30.
    List<Object> findDistinctByCityAndSalesRepresentativeEmployeeCode(String city, Employee employeeCode);

    // Devuelve un listado con los clientes que han realizado algún pedido pero no
    // han realizado ningún pago.
    @Query(value = "SELECT DISTINCT cl FROM Client cl LEFT JOIN cl.paymentList pay LEFT JOIN cl.orderList ord WHERE pay IS NULL AND ord IS NOT NULL")
    List<Object> findClientOrderNoPaid();

}
