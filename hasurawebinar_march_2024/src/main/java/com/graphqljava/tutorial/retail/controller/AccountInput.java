package com.graphqljava.tutorial.retail.controller;

import java.util.List;

public class AccountInput {

    private String name;

    private List<OrderInput> orderInputs;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<OrderInput> getOrderInputs() {
        return this.orderInputs;
    }

    public void setOrderInputs(final List<OrderInput> orderInputs) {
        this.orderInputs = orderInputs;
    }
}
