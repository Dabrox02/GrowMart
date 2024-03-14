package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "oficina")
public class Office {

    @Id
    @Column(name = "codigo_oficina", length = 10)
    private String officeCode;

    @Column(name = "ciudad", length = 30, nullable = false)
    private String city;

    @Column(name = "pais", length = 50, nullable = false)
    private String country;

    @Column(name = "region", length = 50)
    private String region;

    @Column(name = "codigo_postal", length = 10, nullable = false)
    private String postalCode;

    @Column(name = "telefono", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "linea_direccion1", length = 50, nullable = false)
    private String lineAdress1;

    @Column(name = "linea_direccion2", length = 50)
    private String lineAdress2;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Employee> employeeList;


    public Office() {
    }

    public Office(String officeCode, String city, String country, String region, String postalCode, String phoneNumber, String lineAdress1, String lineAdress2, List<Employee> employeeList) {
        this.officeCode = officeCode;
        this.city = city;
        this.country = country;
        this.region = region;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.lineAdress1 = lineAdress1;
        this.lineAdress2 = lineAdress2;
        this.employeeList = employeeList;
    }

    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLineAdress1() {
        return this.lineAdress1;
    }

    public void setLineAdress1(String lineAdress1) {
        this.lineAdress1 = lineAdress1;
    }

    public String getLineAdress2() {
        return this.lineAdress2;
    }

    public void setLineAdress2(String lineAdress2) {
        this.lineAdress2 = lineAdress2;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "{" +
            " officeCode='" + getOfficeCode() + "'" +
            ", city='" + getCity() + "'" +
            ", country='" + getCountry() + "'" +
            ", region='" + getRegion() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", lineAdress1='" + getLineAdress1() + "'" +
            ", lineAdress2='" + getLineAdress2() + "'" +
            ", employeeList='" + getEmployeeList() + "'" +
            "}";
    }
    

}
