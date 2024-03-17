package com.campus.growmart.domain.repository;

import java.util.List;

import com.campus.growmart.persistence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Client;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Devuelve un listado con el nombre de los todos los clientes españoles.
    List<Object> findByCountryLike(String country);

    // Devuelve un listado con todos los clientes que sean de la ciudad de Madrid y cuyo representante de ventas tenga el código de empleado 30.
    @Query("SELECT c.clientCode, c.clientName, c.salesRepresentativeEmployeeCode.employeeCode, c.city  FROM Client c WHERE LOWER(c.city) = LOWER(?1) AND c.salesRepresentativeEmployeeCode.employeeCode IN (?2, ?3)")
    List<Object[]> findClientByCityAndEmployeeCode(String city, String employeeCode1 , String employeeCode2);

    // ¿Cuántos clientes tiene cada país?
    @Query("select  c.country ,count(c.country) as client_number from Client c group by c.country")
    List<Object[]> countByCountry();

    // Calcula el número de clientes que tiene la empresa.
    long count();

    // ¿Cuántos clientes existen con domicilio en la ciudad de Madrid?
    long countByCity(String city);

    // ¿Calcula cuántos clientes tiene cada una de las ciudades que empiezan por 'M'?
    @Query("SELECT COUNT(c) , c.city FROM Client c group by c.city  HAVING LOWER(c.city) LIKE LOWER(:initialLetterCity) || '%'")
    List<Object[]> countClientsCityBeginWith(  @Param("initialLetterCity") String initialLetterCity);


    // Calcula el número de clientes que no tiene asignado representante de ventas.
    @Query("SELECT COUNT(*)  FROM Client c WHERE c.salesRepresentativeEmployeeCode IS NULL")
    List<Object> clientAmountWithoutEmployee();

    // Calcula la fecha del primer y último pago realizado por cada uno de los clientes. El listado deberá mostrar el nombre y los apellidos de cada cliente.
    @Query("SELECT c.clientName, c.contactName, c.contactSurname, MIN(pg.paymentDate) , MAX(pg.paymentDate)  FROM Client c LEFT JOIN c.paymentList pg  GROUP BY c.clientName, c.contactName, c.contactSurname")
    List<Object[]> clientFirstLastPayment ();



}
