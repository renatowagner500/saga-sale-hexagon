package com.renatowagner.payment.application.core.domain;

import java.math.BigDecimal;

public class Payment {
    public Payment() {
    }

    public Payment(Integer id, Integer saleId, Integer userId, BigDecimal value) {
        this.id = id;
        this.saleId = saleId;
        this.userId = userId;
        this.value = value;
    }

    private Integer id;

    private Integer saleId;

    private Integer userId;

    private BigDecimal value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
