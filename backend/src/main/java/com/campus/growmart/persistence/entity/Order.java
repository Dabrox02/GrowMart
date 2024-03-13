package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pedido")
    private Integer orderCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido", nullable = false)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_esperada", nullable = false)
    private Date expectedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date deliveryDate;

    @Column(name = "estado", length = 15, nullable = false)
    private String state;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente", nullable = false, referencedColumnName = "codigo_cliente")
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList;

}
