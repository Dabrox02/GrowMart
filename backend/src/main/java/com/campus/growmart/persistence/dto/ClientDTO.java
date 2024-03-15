package com.campus.growmart.persistence.dto;

import java.util.List;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {
    private Integer clientCode;
    private String clientName;
    private String contactName;
    private String contactSurname;
    private String phoneNumber;
    private String fax;
    private String lineAdress1;
    private String lineAdress2;
    private String city;
    private String region;
    private String country;
    private String postalCode;
    private BigDecimal creditLimit;

    private EmployeeDTO salesRepresentativeEmployeeCode;
    private List<ProductRangeDTO> productRangeDTO;

    public ClientDTO() {
    }

    public Integer getClientCode() {
        return clientCode;
    }

    public void setClientCode(Integer clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLineAdress1() {
        return lineAdress1;
    }

    public void setLineAdress1(String lineAdress1) {
        this.lineAdress1 = lineAdress1;
    }

    public String getLineAdress2() {
        return lineAdress2;
    }

    public void setLineAdress2(String lineAdress2) {
        this.lineAdress2 = lineAdress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public EmployeeDTO getSalesRepresentativeEmployeeCode() {
        return salesRepresentativeEmployeeCode;
    }

    public void setSalesRepresentativeEmployeeCode(EmployeeDTO salesRepresentativeEmployeeCode) {
        this.salesRepresentativeEmployeeCode = salesRepresentativeEmployeeCode;
    }

    public List<ProductRangeDTO> getProductRangeDTO() {
        return this.productRangeDTO;
    }

    public void setProductRangeDTO(List<ProductRangeDTO> productRangeDTO) {
        this.productRangeDTO = productRangeDTO;
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
                "}";
    }

}
