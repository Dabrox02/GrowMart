package com.campus.growmart.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

import com.campus.growmart.persistence.dto.ClientDTO;

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

    @Column(name = "limite_credito", precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @ManyToOne
    @JoinColumn(name = "codigo_empleado_rep_ventas", referencedColumnName = "codigo_empleado")
    private Employee salesRepresentativeEmployeeCode;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Payment> paymentList;

    public Integer getClientCode() {
        return this.clientCode;
    }

    public void setClientCode(Integer clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactSurname() {
        return this.contactSurname;
    }

    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public BigDecimal getCreditLimit() {
        return this.creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Employee getSalesRepresentativeEmployeeCode() {
        return this.salesRepresentativeEmployeeCode;
    }

    public void setSalesRepresentativeEmployeeCode(Employee salesRepresentativeEmployeeCode) {
        this.salesRepresentativeEmployeeCode = salesRepresentativeEmployeeCode;
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Payment> getPaymentList() {
        return this.paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public ClientDTO convertToDto() {
        ClientDTO dto = new ClientDTO();
        dto.setClientCode(this.clientCode);
        dto.setClientName(this.clientName);
        dto.setContactName(this.contactName);
        dto.setContactSurname(this.contactSurname);
        dto.setPhoneNumber(this.phoneNumber);
        dto.setFax(this.fax);
        dto.setLineAdress1(this.lineAdress1);
        dto.setLineAdress2(this.lineAdress2);
        dto.setCity(this.city);
        dto.setRegion(this.region);
        dto.setCountry(this.country);
        dto.setPostalCode(this.postalCode);
        dto.setCreditLimit(this.creditLimit);
        return dto;
    }

    @Override
    public String toString() {
        return "{" +
                " clientCode='" + getClientCode() + "'" +
                ", clientName='" + getClientName() + "'" +
                ", contactName='" + getContactName() + "'" +
                ", contactSurname='" + getContactSurname() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", fax='" + getFax() + "'" +
                ", lineAdress1='" + getLineAdress1() + "'" +
                ", lineAdress2='" + getLineAdress2() + "'" +
                ", city='" + getCity() + "'" +
                ", region='" + getRegion() + "'" +
                ", country='" + getCountry() + "'" +
                ", postalCode='" + getPostalCode() + "'" +
                ", creditLimit='" + getCreditLimit() + "'" +
                ", salesRepresentativeEmployeeCode='" + getSalesRepresentativeEmployeeCode() + "'" +
                ", orderList='" + getOrderList() + "'" +
                ", paymentList='" + getPaymentList() + "'" +
                "}";
    }

}
