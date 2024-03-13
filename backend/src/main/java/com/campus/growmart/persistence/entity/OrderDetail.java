package com.campus.growmart.persistence.entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")

public class OrderDetail  {


    @EmbeddedId
    private OrderDetailId id;




    @Column(name = "cantidad", nullable = false)
    private Integer amount;

    @Column(name = "precio_unidad", precision = 15, scale = 2, nullable = false)
    private BigDecimal priceByUnit;

    @Column(name = "numero_linea", nullable = false)
    private Short lineNumber;


}
