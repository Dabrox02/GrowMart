package com.campus.growmart.persistence.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDTO {

    private String transactionId;
    private String paymentMethod;
    private Date paymentDate;
    private BigDecimal total;
    private ClientDTO client;

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public ClientDTO getClient() {
        return this.client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }


    @Override
    public String toString() {
        return "{" +
            " transactionId='" + getTransactionId() + "'" +
            ", paymentMethod='" + getPaymentMethod() + "'" +
            ", paymentDate='" + getPaymentDate() + "'" +
            ", total='" + getTotal() + "'" +
            ", client='" + getClient() + "'" +
            "}";
    }

    
}
