package com.campus.growmart.persistence.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {
    private Integer employeeCode;
    private String name;
    private String surname1;
    private String surname2;
    private String extension;
    private String email;
    private String position;
    private OfficeDTO office;
    private EmployeeDTO boss;
    private List<EmployeeDTO> subordinateList;
    private List<ClientDTO> clientList;

    public EmployeeDTO() {
    }

    public Integer getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(Integer employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public OfficeDTO getOffice() {
        return office;
    }

    public void setOffice(OfficeDTO office) {
        this.office = office;
    }

    public EmployeeDTO getBoss() {
        return boss;
    }

    public void setBoss(EmployeeDTO boss) {
        this.boss = boss;
    }

    public List<EmployeeDTO> getSubordinateList() {
        return subordinateList;
    }

    public void setSubordinateList(List<EmployeeDTO> subordinateList) {
        this.subordinateList = subordinateList;
    }

    public List<ClientDTO> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientDTO> clientList) {
        this.clientList = clientList;
    }
}
