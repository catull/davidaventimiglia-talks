package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.repository.OrderDetailRepository;
import com.graphqljava.tutorial.retail.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderRepository;

    public OrderDetailService(final OrderDetailRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDetail getOrderDetailById(final UUID id) {
        return this.orderRepository.findById(id).orElse(null);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return this.orderRepository.findAll();
    }

    public List<OrderDetail> getAllOrderDetailsLimitedTo(final int limit) {
        return this.orderRepository.findAllLimitedTo(limit);
    }

    public OrderDetail createOrderDetail(final OrderDetail order) {
        return this.orderRepository.save(order);
    }

    public void deleteOrderDetailById(final UUID id) {
        this.orderRepository.deleteById(id);
    }
}
