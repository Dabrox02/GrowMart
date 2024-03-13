package com.campus.growmart.persistence.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pago")
public class Payment {


    @EmbeddedId
    private PaymentId id;



    @Column(name = "forma_pago", length = 40, nullable = false)
    private String paymentMethod;

    @Column(name = "fecha_pago", nullable = false)
    private Date paymentDate;

    @Column(name = "total", precision = 15, scale = 2, nullable = false)
    private BigDecimal total;

}
