package com.campus.growmart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    // Devuelve un listado con todos los productos que pertenecen a la gama Ornamentales y que tienen mas de 100 unidades en stock. El listado debera estar ordenado por su precio de venta, mostrando en primer lugar los de mayor precio.
    @Query("SELECT p.productCode, p.name, p.productRange.range, p.stock, p.salePrice  FROM Product p WHERE LOWER(p.productRange) = ?1 AND p.stock > ?2 ORDER BY p.salePrice DESC")
    List<Object[]> findProductRangeStock(String range, String stock);


    // Calcula el precio de venta del producto más caro y más barato en una misma consulta.
    @Query("SELECT MIN(p.salePrice  ) AS most_expensive, MAX(p.salePrice) AS chipest FROM Product p")
    List<Object[]> findMostExpesiveAndChespest();

}
