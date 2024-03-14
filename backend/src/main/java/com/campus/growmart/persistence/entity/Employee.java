package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "empleado")
public class Employee {

    @Id
    @Column(name = "codigo_empleado")
    private Integer employeeCode;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "apellido1", length = 50, nullable = false)
    private String surname1;

    @Column(name = "apellido2", length = 50)
    private String surname2;

    @Column(name = "extension", length = 10, nullable = false)
    private String extension;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "puesto", length = 50)
    private String position;

    @ManyToOne
    @JoinColumn(name = "codigo_oficina", referencedColumnName = "codigo_oficina", nullable = false)
    private Office office;

    @ManyToOne
    @JoinColumn(name = "codigo_jefe", referencedColumnName = "codigo_empleado")
    private Employee boss;

    @OneToMany(mappedBy = "boss", cascade = CascadeType.ALL)
    private List<Employee> subordinateList;

    @OneToMany(mappedBy = "salesRepresentativeEmployeeCode", cascade = CascadeType.ALL)
    private List<Client> clientList;

    public Integer getEmployeeCode() {
        return this.employeeCode;
    }

    public void setEmployeeCode(Integer employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return this.surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return this.surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Office getOffice() {
        return this.office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee getBoss() {
        return this.boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public List<Employee> getSubordinateList() {
        return this.subordinateList;
    }

    public void setSubordinateList(List<Employee> subordinateList) {
        this.subordinateList = subordinateList;
    }

    public List<Client> getClientList() {
        return this.clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "{" +
                " employeeCode='" + getEmployeeCode() + "'" +
                ", name='" + getName() + "'" +
                ", surname1='" + getSurname1() + "'" +
                ", surname2='" + getSurname2() + "'" +
                ", extension='" + getExtension() + "'" +
                ", email='" + getEmail() + "'" +
                ", position='" + getPosition() + "'" +
                ", office='" + getOffice() + "'" +
                ", boss='" + getBoss() + "'" +
                ", subordinateList='" + getSubordinateList() + "'" +
                ", clientList='" + getClientList() + "'" +
                "}";
    }

}
