package com.graphqljava.tutorial.retail.controller;

import com.graphqljava.tutorial.retail.model.Order;
import com.graphqljava.tutorial.retail.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {

	private final OrderService orderService;
	private final InputConverter inputConverter;

	public OrderController(final OrderService orderService, final InputConverter inputConverter) {
		this.orderService = orderService;
        this.inputConverter = inputConverter;
    }

	@QueryMapping(name = "orderById")
	public Order getOrderById(final @Argument UUID id) {
		return this.orderService.getOrderById(id);
	}

	@QueryMapping(name = "allOrders")
	public List<Order> getOrders() {
		return this.orderService.getAllOrders();
	}

	@QueryMapping(name = "allOrdersWithLimit")
	public List<Order> getAllOrdersWithLimit(final @Argument int limit) {
		return this.orderService.getAllOrdersLimitedTo(limit);
	}

	@MutationMapping(name = "createOrder")
	public Order createOrder(final @Argument OrderInput orderInput) {
		Order order = this.inputConverter.convert(orderInput);

		return this.orderService.createOrder(order);
	}

	@MutationMapping(name = "deleteOrderById")
	public Order deleteOrderById(final @Argument UUID id) {
		this.orderService.deleteOrderById(id);

		return null;
	}

}
