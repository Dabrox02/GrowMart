package com.campus.growmart.domain.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.growmart.persistence.entity.OrderDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Object> {
    //Calcula el número de productos diferentes que hay en cada uno de los pedidos.
    @Query("SELECT od.order.orderCode, COUNT(DISTINCT od.product.productCode)  FROM OrderDetail od GROUP BY od.order.orderCode")
    List<Object[]> amountDistinctProductsInOrder();

    // Calcula la suma de la cantidad total de todos los productos que aparecen en cada uno de los pedidos.
    @Query("SELECT od.order.orderCode, COUNT( od.product.productCode)  FROM OrderDetail od GROUP BY od.order.orderCode")
    List<Object[]> amountProductsInOrder();

    // Devuelve un listado de los 20 productos más vendidos y el número total de unidades que se han vendido de cada uno. El listado deberá estar ordenado por el número total de unidades vendidas.

    @Query ("SELECT od.product.name , SUM(od.amount)  FROM OrderDetail od  GROUP BY od.product.name ORDER BY SUM(od.amount) DESC ")
    List<Object[]>  findBestSellingProducts(Pageable pageable );

    //La facturación que ha tenido la empresa en toda la historia, indicando la base imponible, el IVA y el total facturado. La base imponible se calcula sumando el coste del producto por el número de unidades vendidas de la tabla detalle_pedido. El IVA es el 21 % de la base imponible, y el total la suma de los dos campos anteriores.

    @Query("SELECT SUM(od.amount * od.product.salePrice) , SUM(od.amount * od.product.salePrice) * 0.21 , SUM(od.amount *od.product.salePrice) + (SUM(od.amount * od.product.salePrice) * 0.21)  FROM OrderDetail od ")
    List<Object[]> findCompanyBilling();

    //La misma información que en la pregunta anterior, pero agrupada por código de producto.
    @Query("SELECT  od.product.productCode , SUM(od.amount * od.product.salePrice) , SUM(od.amount * od.product.salePrice) * 0.21 , SUM(od.amount *od.product.salePrice) + (SUM(od.amount * od.product.salePrice) * 0.21)  FROM OrderDetail od  GROUP BY od.product.productCode")
    List<Object[]> findCompanyBillingProductCode();

    //La misma información que en la pregunta anterior, pero agrupada por código de producto filtrada por los códigos que empiecen por 'OR'
    @Query("SELECT  od.product.productCode , SUM(od.amount * od.product.salePrice) , SUM(od.amount * od.product.salePrice) * 0.21 , SUM(od.amount *od.product.salePrice) + (SUM(od.amount * od.product.salePrice) * 0.21)  FROM OrderDetail od WHERE LOWER(od.product.productCode) LIKE LOWER(  ?1 || '%' )  GROUP BY od.product.productCode")
    List<Object[]> findCompanyBillingProductCodeBeginsWith(String beginsWith);

    // Lista las ventas totales de los productos que hayan facturado más de 3000 euros. Se mostrará el nombre, unidades vendidas, total facturado y total facturado con impuestos (21% IVA).

    @Query("SELECT od.product.name , SUM(od.amount) , SUM(od.amount * od.priceByUnit) , SUM(od.amount * od.priceByUnit) * 1.21 FROM OrderDetail od  GROUP BY od.product.name HAVING SUM(od.amount * od.priceByUnit) > ?1")
    List<Object[]> findProductsBillingMoreThan( String moreThan);


}
