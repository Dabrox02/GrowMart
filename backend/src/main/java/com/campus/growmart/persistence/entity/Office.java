package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "oficina")
public class Office {

    @Id
    @Column(name = "codigo_oficina", length = 10)
    private String officeCode;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "pais")
    private String country;

    @Column(name = "region")
    private String region;

    @Column(name = "codigo_postal", length = 10)
    private String postalCode;

    @Column(name = "telefono", length = 20)
    private String phoneNumber;

    @Column(name = "linea_direccion1", length = 50, nullable = false)
    private String lineAdress1;

    @Column(name = "linea_direccion2", length = 50)
    private String lineAdress2;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

}
