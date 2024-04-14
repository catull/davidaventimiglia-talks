package com.graphqljava.tutorial.retail.repository;

import com.graphqljava.tutorial.retail.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class OrderRepositoryImpl implements AllLimited<Order> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAllLimitedTo(int limit) {
        return entityManager
                .createQuery("SELECT b FROM Order b", Order.class)
                .setMaxResults(limit)
                .getResultList();
    }
}
