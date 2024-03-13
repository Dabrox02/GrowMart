package com.campus.growmart.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class PaymentId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "codigo_cliente" , referencedColumnName = "codigo_cliente")
    private Client client;


    @Column(name = "id_transaccion")
    private String transactionId;

}
