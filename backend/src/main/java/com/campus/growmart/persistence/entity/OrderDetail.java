package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")

public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "codigo_pedido", referencedColumnName = "codigo_pedido")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto")
    private Product product;

    @Column(name = "cantidad", nullable = false)
    private Integer amount;

    @Column(name = "precio_unidad", precision = 15, scale = 2, nullable = false)
    private BigDecimal priceByUnit;

    @Column(name = "numero_linea", nullable = false)
    private Short lineNumber;

}
