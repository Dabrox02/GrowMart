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

}
