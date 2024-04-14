package com.graphqljava.tutorial.retail.controller;

import com.graphqljava.tutorial.retail.model.Account;
import com.graphqljava.tutorial.retail.model.Order;
import com.graphqljava.tutorial.retail.model.OrderDetail;
import com.graphqljava.tutorial.retail.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InputConverter {

    public Account convert(final AccountInput accountInput) {
        if (null == accountInput) {
            return null;
        }

        return Account.builder()
                .withName(accountInput.getName())
                .withOrders(convertOrders(accountInput.getOrderInputs()))
                .build();
    }

    public Order convert(final OrderInput orderInput) {
        if (null == orderInput) {
            return null;
        }

        return Order.builder()
                .withStatus(orderInput.getStatus())
                .withAccount(convert(orderInput.getAccountInput()))
                .build();
    }

    public OrderDetail convert(final OrderDetailInput orderDetailInput) {
        if (null == orderDetailInput) {
            return null;
        }

        return OrderDetail.builder()
                .withUnits(orderDetailInput.getUnits())
                .withOrder(convert(orderDetailInput.getOrderInput()))
                .withProduct(convert(orderDetailInput.getProductInput()))
                .build();
    }

    public Product convert(final ProductInput productInput) {
        if (null == productInput) {
            return null;
        }

        return Product.builder()
                .withName(productInput.getName())
                .withPrice(productInput.getPrice())
                .withOrderDetails(convertOrderDetails(productInput.getOrderDetailInputs()))
                .build();
    }

    public List<Order> convertOrders(final List<OrderInput> orderInputs) {
        if (null == orderInputs || orderInputs.isEmpty()) {
            return null;
        }

        return orderInputs.stream().map(this::convert).toList();
    }

    public List<OrderDetail> convertOrderDetails(final List<OrderDetailInput> orderInputs) {
        if (null == orderInputs || orderInputs.isEmpty()) {
            return null;
        }

        return orderInputs.stream().map(this::convert).toList();
    }
}
