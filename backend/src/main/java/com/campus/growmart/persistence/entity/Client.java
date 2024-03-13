package com.campus.growmart.persistence.entity;


import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cliente")

public class Client {

    @Id
    @Column(name = "codigo_cliente")
    private Integer clientCode;

    @Column(name = "nombre_cliente", length = 50, nullable = false)
    private String clientName;

    @Column(name = "nombre_contacto", length = 30)
    private String contactName;

    @Column(name = "apellido_contacto", length = 30)
    private String contactSurname;

    @Column(name = "telefono", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "fax", length = 15, nullable = false)
    private String fax;

    @Column(name = "linea_direccion1", length = 50, nullable = false)
    private String lineAdress1;

    @Column(name = "linea_direccion2", length = 50)
    private String lineAdress2;

    @Column(name = "ciudad", length = 50, nullable = false)
    private String city;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "pais", length = 50)
    private String country;

    @Column(name = "codigo_postal", length = 10)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "codigo_empleado_rep_ventas" , referencedColumnName = "codigo_empleado")
    private Employee salesRepresentativeEmployeeCode;

    @Column(name = "limite_credito", precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orderList;


    @OneToMany(mappedBy = "id.client", cascade = CascadeType.ALL)
    private List<Payment> paymentList;

}
