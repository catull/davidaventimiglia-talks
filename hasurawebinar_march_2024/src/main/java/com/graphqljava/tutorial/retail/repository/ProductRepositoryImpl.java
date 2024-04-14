package com.graphqljava.tutorial.retail.repository;

import com.graphqljava.tutorial.retail.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ProductRepositoryImpl implements AllLimited<Product> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAllLimitedTo(int limit) {
        return entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .setMaxResults(limit)
                .getResultList();
    }
}
