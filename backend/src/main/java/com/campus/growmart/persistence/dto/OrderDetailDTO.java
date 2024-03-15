package com.campus.growmart.persistence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailDTO {

    private Long orderDetailId;

    private OrderDTO order;

    private ProductDTO product;

    private Integer amount;

    private BigDecimal priceByUnit;

    private Short lineNumber;

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getPriceByUnit() {
        return priceByUnit;
    }

    public void setPriceByUnit(BigDecimal priceByUnit) {
        this.priceByUnit = priceByUnit;
    }

    public Short getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Short lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderDetailId=" + orderDetailId +
                ", order=" + order +
                ", product=" + product +
                ", amount=" + amount +
                ", priceByUnit=" + priceByUnit +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
