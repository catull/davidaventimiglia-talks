package com.graphqljava.tutorial.retail.controller;

import java.util.List;

public class OrderInput {

    private String status;

    private String region;

    private AccountInput accountInput;

    private List<OrderDetailInput> orderDetailInputs;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public AccountInput getAccountInput() {
        return this.accountInput;
    }

    public void setAccountInput(final AccountInput accountInput) {
        this.accountInput = accountInput;
    }

    public List<OrderDetailInput> getOrderDetailInputs() {
        return this.orderDetailInputs;
    }

    public void setOrderDetailInputs(final List<OrderDetailInput> orderDetailInputs) {
        this.orderDetailInputs = orderDetailInputs;
    }
}
