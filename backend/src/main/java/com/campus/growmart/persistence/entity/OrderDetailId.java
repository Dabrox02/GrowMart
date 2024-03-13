package com.campus.growmart.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Embeddable
public class OrderDetailId   implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_pedido" ,referencedColumnName = "codigo_pedido")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto")
    private Product product;


}
