package com.campus.growmart.persistence.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private Integer orderCode;

    private Date orderDate;

    private Date expectedDate;

    private Date deliveryDate;

    private String state;

    private String comments;

    private ClientDTO client;

    private List<OrderDetailDTO> orderDetailList;


    public Integer getOrderCode() {
        return this.orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getExpectedDate() {
        return this.expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ClientDTO getClient() {
        return this.client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<OrderDetailDTO> getOrderDetailList() {
        return this.orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailDTO> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return "{" +
            " orderCode='" + getOrderCode() + "'" +
            ", orderDate='" + getOrderDate() + "'" +
            ", expectedDate='" + getExpectedDate() + "'" +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", state='" + getState() + "'" +
            ", comments='" + getComments() + "'" +
            ", client='" + getClient() + "'" +
            ", orderDetailList='" + getOrderDetailList() + "'" +
            "}";
    }


}
