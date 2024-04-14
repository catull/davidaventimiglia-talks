package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.repository.OrderRepository;
import com.graphqljava.tutorial.retail.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(final UUID id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public List<Order> getAllOrdersLimitedTo(final int limit) {
        return this.orderRepository.findAllLimitedTo(limit);
    }

    public Order createOrder(final Order order) {
        return this.orderRepository.save(order);
    }

    public void deleteOrderById(final UUID id) {
        this.orderRepository.deleteById(id);
    }
}
