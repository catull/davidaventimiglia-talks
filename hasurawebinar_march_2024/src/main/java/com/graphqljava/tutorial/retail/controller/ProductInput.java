package com.graphqljava.tutorial.retail.controller;

import java.util.List;

public class ProductInput {

    private String name;

    private Integer price;

    private List<OrderDetailInput> orderDetailInputs;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public List<OrderDetailInput> getOrderDetailInputs() {
        return orderDetailInputs;
    }

    public void setOrderDetailInputs(final List<OrderDetailInput> orderDetailInputs) {
        this.orderDetailInputs = orderDetailInputs;
    }
}
