package com.graphqljava.tutorial.retail.controller;

import java.util.List;

public class OrderInput {

    private String status;

    private AccountInput accountInput;

    private List<OrderDetailInput> orderDetailInputs;

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public AccountInput getAccountInput() {
        return accountInput;
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
