package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "empleado")
public class Employee {


    @Id
    @Column(name = "codigo_empleado")
    private Integer employeeCode;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido1")
    private String surname1;

    @Column(name = "apellido2")
    private String surname2;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "puesto")
    private String position;

    @ManyToOne
    @JoinColumn(name = "codigo_oficina", referencedColumnName = "codigo_oficina")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "codigo_jefe", referencedColumnName = "codigo_empleado")
    private Employee boss;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Employee> subordinateList;

    @OneToMany(mappedBy = "salesRepresentativeEmployeeCode", cascade = CascadeType.ALL)
    private List<Client> clientList;
}
