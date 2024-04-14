package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.model.Account;
import com.graphqljava.tutorial.retail.model.OrderDetail;
import com.graphqljava.tutorial.retail.repository.AccountRepository;
import com.graphqljava.tutorial.retail.repository.OrderDetailRepository;
import com.graphqljava.tutorial.retail.repository.OrderRepository;
import com.graphqljava.tutorial.retail.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final AccountRepository accountRepository;

    public OrderService(
            final OrderRepository orderRepository,
            final OrderDetailRepository orderDetailRepository,
            final AccountRepository accountRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.accountRepository = accountRepository;
    }

    public Order getOrderById(final UUID id) {
        Order order = this.orderRepository.findById(id).orElse(null);

        if (null == order) {
            return null;
        }

        Account account = this.accountRepository.findById(order.getAccountId()).orElse(null);
        order.setAccount(account);
        List<OrderDetail> orderDetails = this.orderDetailRepository.findAllByOrderId(id);
        order.setOrderDetails(orderDetails);

        return order;
    }

    public List<Order> getAllOrders() {
        return enhanceOrders(this.orderRepository.findAll());
    }

    public List<Order> getAllOrdersLimitedTo(final int limit) {
        return enhanceOrders(this.orderRepository.findAllLimitedTo(limit));
    }

    private List<Order> enhanceOrders(final List<Order> orders) {
        for (Order order : orders) {
            Account account = this.accountRepository.findById(order.getAccountId()).orElse(null);
            order.setAccount(account);
            List<OrderDetail> orderDetails = this.orderDetailRepository.findAllByOrderId(order.getId());
            order.setOrderDetails(orderDetails);
        }

        return orders;
    }

    public Order createOrder(final Order order) {
        return this.orderRepository.save(order);
    }

    public void deleteOrderById(final UUID id) {
        this.orderRepository.deleteById(id);
    }
}
