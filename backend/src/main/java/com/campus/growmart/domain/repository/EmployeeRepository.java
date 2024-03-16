package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.campus.growmart.persistence.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Devuelve un listado con el nombre, apellidos y email de los empleados cuyo
    // jefe tiene un código de jefe igual a 7.
    @Query("SELECT e.name, e.surname1, e.surname2 FROM Employee e WHERE e.boss.employeeCode = :bossCode")
    List<Object[]> findNameLastnameByCodeBoss(@Param("bossCode") Integer bossCode);

    // Devuelve el nombre del puesto, nombre, apellido y email del jefe de la
    // empresa.
    @Query("SELECT e.name, e.surname1, e.surname2, e.email, e.position FROM Employee e WHERE e.boss.employeeCode IS NULL")
    List<Object[]> findBossCompany();

    // Devuelve un listado con el nombre, apellidos y puesto de aquellos empleados
    // que no sean representantes de ventas.
    List<Object> findByPositionNotLike(String position);

    // ¿Cuántos empleados hay en la compañía?
    long count();

    // Devuelve el nombre de los representantes de ventas y el número de clientes
    // al que atiende cada uno.
    @Query("SELECT CONCAT(e.name, ' ', e.surname1) , COUNT(c.clientCode) FROM Employee e LEFT JOIN e.clientList c GROUP BY e.name, e.surname1")
    List<Object[]> findEmployeeAmountClients();

    // Devuelve un listado con el nombre de los empleados junto con el nombre de sus
    // jefes.
    @Query(value = "SELECT DISTINCT emp.nombre, emp.apellido1, j1.nombre, j1.apellido1 FROM empleado emp LEFT JOIN empleado j1 ON emp.codigo_jefe = j1.codigo_empleado", nativeQuery = true)
    List<Object[]> findNameEmployeeWithNameBoss();

    // Devuelve un listado que muestre el nombre de cada empleados, el nombre de su
    // jefe y el nombre del jefe de sus jefe.
    @Query(value = "SELECT DISTINCT emp.nombre, emp.apellido1, j1.nombre, j1.apellido1, j2.nombre, j2.apellido1 FROM empleado emp LEFT JOIN empleado j1 ON emp.codigo_jefe = j1.codigo_empleado LEFT JOIN empleado j2 ON j1.codigo_jefe = j2.codigo_empleado", nativeQuery = true)
    List<Object[]> findEmployeeWithBossWithBoss();

    // Devuelve un listado que muestre solamente los empleados que no tienen una
    // oficina asociada.
    @Query(value = "SELECT e.codigo_empleado, e.nombre, e.apellido1, e.apellido2, e.puesto, e.email, e.extension FROM empleado e LEFT JOIN oficina ofi ON e.codigo_oficina = ofi.codigo_oficina WHERE e.codigo_oficina IS NULL", nativeQuery = true)
    List<Object[]> findEmployeeAllNoOffice();

    // Devuelve un listado que muestre solamente los empleados que no tienen un
    // cliente asociado.
    @Query(value = "SELECT e.codigo_empleado, e.nombre, e.apellido1, e.apellido2, e.puesto, e.email, e.extension FROM empleado e LEFT JOIN cliente c ON e.codigo_empleado = c.codigo_empleado_rep_ventas WHERE c.codigo_empleado_rep_ventas IS NULL", nativeQuery = true)
    List<Object[]> findEmployeeAllNoClient();

    // Devuelve un listado que muestre solamente los empleados que no tienen un
    // cliente asociado junto con los datos de la oficina donde trabajan.
    @Query(value = "SELECT e.name, e.surname1, e.surname2, e.extension, e.email, e.position, ofi.city, ofi.country, ofi.postalCode, ofi.phoneNumber \n"
            +
            "FROM Employee e \n" +
            "JOIN e.office ofi\n" +
            "LEFT JOIN e.clientList c\n" +
            "WHERE c IS NULL")
    List<Object[]> findEmployeeOfficeNoClient();

    // Devuelve un listado que muestre los empleados que no tienen una oficina
    // asociada y los que no tienen un cliente asociado.
    @Query(value = "SELECT e.name, e.surname1, e.surname2, e.extension, e.email, e.position FROM Employee e  LEFT JOIN e.office ofi LEFT JOIN e.clientList c WHERE c IS NULL OR e.office IS NULL")
    List<Object[]> findEmployeeAllNoOfficeNoClient();

    // Devuelve un listado con los datos de los empleados que no tienen clientes
    // asociados y el nombre de su jefe asociado.
    @Query(value = "SELECT e.employeeCode, e.name, e.surname1, e.surname2, e.email, e.extension, e.position, b.name  FROM Employee e LEFT JOIN e.boss b LEFT JOIN e.clientList c WHERE c IS NULL")
    List<Object[]> findEmployeeAllNoClientWithBoss();

}
