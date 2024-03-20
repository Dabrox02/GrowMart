package com.campus.growmart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.campus.growmart.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    // Devuelve un listado con todos los productos que pertenecen a la gama
    // Ornamentales y que tienen mas de 100 unidades en stock. El listado debera
    // estar ordenado por su precio de venta, mostrando en primer lugar los de mayor
    // precio.
    @Query("SELECT p.productCode, p.name, p.productRange.range, p.stock, p.salePrice FROM Product p WHERE LOWER(p.productRange) = LOWER(?1) AND p.stock > ?2 ORDER BY p.salePrice DESC")
    List<Object[]> findProductRangeStock(String range, String stock);

    // Devuelve un listado de los productos que nunca han aparecido en un pedido.
    @Query("SELECT DISTINCT pd.productCode, pd.name FROM Product pd LEFT JOIN pd.orderDetailList dp WHERE dp IS NULL")
    List<Object[]> findProductNoOrder();

    // Calcula el precio de venta del producto más caro y más barato en una misma
    // consulta.
    @Query("SELECT MIN(p.salePrice  ) AS most_expensive, MAX(p.salePrice) AS chipest FROM Product p")
    List<Object[]> findMostExpesiveAndChespest(); 
    
    // Devuelve un listado de los productos que nunca han aparecido en un pedido. El resultado debe mostrar el nombre, la descripción y la imagen del producto.
    @Query("SELECT DISTINCT pd.productCode, pd.name, g.textDescription, g.image FROM Product pd JOIN pd.productRange g LEFT JOIN pd.orderDetailList dp WHERE dp IS NULL")
    List<Object[]> findProductNoOrderAll();

}
