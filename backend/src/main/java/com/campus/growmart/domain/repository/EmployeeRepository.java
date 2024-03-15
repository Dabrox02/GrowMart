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

    
}
