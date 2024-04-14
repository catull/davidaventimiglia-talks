package com.graphqljava.tutorial.retail.controller;

public class OrderDetailInput {

    private Integer units;

    private ProductInput productInput;

    private OrderInput orderInput;

    public Integer getUnits() {
        return this.units;
    }

    public void setUnits(final Integer units) {
        this.units = units;
    }

    public ProductInput getProductInput() {
        return this.productInput;
    }

    public void setProductInput(final ProductInput productInput) {
        this.productInput = productInput;
    }

    public OrderInput getOrderInput() {
        return this.orderInput;
    }

    public void setOrderInput(final OrderInput orderInput) {
        this.orderInput = orderInput;
    }
}
