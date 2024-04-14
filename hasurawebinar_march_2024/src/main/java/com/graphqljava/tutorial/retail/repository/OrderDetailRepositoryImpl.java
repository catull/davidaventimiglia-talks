package com.graphqljava.tutorial.retail.repository;

import com.graphqljava.tutorial.retail.model.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class OrderDetailRepositoryImpl implements AllLimited<OrderDetail> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderDetail> findAllLimitedTo(int limit) {
        return entityManager
                .createQuery("SELECT o FROM OrderDetail o", OrderDetail.class)
                .setMaxResults(limit)
                .getResultList();
    }
}
