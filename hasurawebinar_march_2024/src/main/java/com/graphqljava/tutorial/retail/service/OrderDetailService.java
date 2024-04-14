package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.model.Order;
import com.graphqljava.tutorial.retail.model.Product;
import com.graphqljava.tutorial.retail.repository.OrderDetailRepository;
import com.graphqljava.tutorial.retail.model.OrderDetail;
import com.graphqljava.tutorial.retail.repository.OrderRepository;
import com.graphqljava.tutorial.retail.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderDetailService(
            final OrderDetailRepository orderDetailRepository,
            final OrderRepository orderRepository,
            final ProductRepository productRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderDetail getOrderDetailById(final UUID id) {
        OrderDetail orderDetail = this.orderDetailRepository.findById(id).orElse(null);

        if (null == orderDetail) {
            return null;
        }

        Product product = this.productRepository.findById(orderDetail.getProductId()).orElse(null);
        orderDetail.setProduct(product);
        Order order = this.orderRepository.findById(orderDetail.getOrderId()).orElse(null);
        orderDetail.setOrder(order);

        return orderDetail;
    }

    public List<OrderDetail> getAllOrderDetails() {
        return enhanceOrderDetails(this.orderDetailRepository.findAll());
    }

    public List<OrderDetail> getAllOrderDetailsLimitedTo(final int limit) {
        return enhanceOrderDetails(this.orderDetailRepository.findAllLimitedTo(limit));
    }

    private List<OrderDetail> enhanceOrderDetails(final List<OrderDetail> orderDetails) {
        for (OrderDetail orderDetail : orderDetails) {
            Product product = this.productRepository.findById(orderDetail.getProductId()).orElse(null);
            orderDetail.setProduct(product);
            Order order = this.orderRepository.findById(orderDetail.getOrderId()).orElse(null);
            orderDetail.setOrder(order);
        }

        return orderDetails;
    }

    public OrderDetail createOrderDetail(final OrderDetail order) {
        return this.orderDetailRepository.save(order);
    }

    public void deleteOrderDetailById(final UUID id) {
        this.orderDetailRepository.deleteById(id);
    }
}
