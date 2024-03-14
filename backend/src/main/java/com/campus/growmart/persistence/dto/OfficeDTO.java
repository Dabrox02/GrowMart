package com.campus.growmart.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficeDTO {
    private String officeCode;
    private String city;
    private String country;
    private String region;
    private String postalCode;
    private String phoneNumber;
    private String lineAdress1;
    private String lineAdress2;

    public OfficeDTO() {
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
                "}";
    }

}
