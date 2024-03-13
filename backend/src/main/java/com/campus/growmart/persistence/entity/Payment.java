package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pago")
public class Payment {

    @Id
    @Column(name = "id_transaccion", length = 50)
    private String transactionId;

    @Column(name = "forma_pago", length = 40, nullable = false)
    private String paymentMethod;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", precision = 15, scale = 2, nullable = false)
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo_cliente")
    private Client client;

}
