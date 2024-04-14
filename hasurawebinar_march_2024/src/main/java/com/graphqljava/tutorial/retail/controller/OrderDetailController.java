package com.graphqljava.tutorial.retail.controller;

import java.util.List;
import java.util.UUID;

import com.graphqljava.tutorial.retail.model.OrderDetail;
import com.graphqljava.tutorial.retail.service.OrderDetailService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderDetailController {

	private final OrderDetailService orderDetailService;
	private final InputConverter inputConverter;

	public OrderDetailController(final OrderDetailService orderService, final InputConverter inputConverter) {
		this.orderDetailService = orderService;
        this.inputConverter = inputConverter;
    }

	@QueryMapping(name = "orderDetailById")
	public OrderDetail getOrderDetailById(final @Argument UUID id) {
		return this.orderDetailService.getOrderDetailById(id);
	}

	@QueryMapping(name = "allOrderDetails")
	public List<OrderDetail> getOrderDetails() {
		return this.orderDetailService.getAllOrderDetails();
	}

	@QueryMapping(name = "allOrderDetailsWithLimit")
	public List<OrderDetail> getAllOrderDetailsWithLimit(final @Argument int limit) {
		return this.orderDetailService.getAllOrderDetailsLimitedTo(limit);
	}

	@MutationMapping(name = "createOrderDetail")
	public OrderDetail createOrderDetail(final @Argument OrderDetailInput orderDetailInput) {
		OrderDetail orderDetail = this.inputConverter.convert(orderDetailInput);

		return this.orderDetailService.createOrderDetail(orderDetail);
	}

	@MutationMapping(name = "deleteOrderDetailById")
	public OrderDetail deleteOrderDetailById(final @Argument UUID id) {
		this.orderDetailService.deleteOrderDetailById(id);

		return null;
	}

}
