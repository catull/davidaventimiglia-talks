package com.graphqljava.tutorial.retail.repository;

import com.graphqljava.tutorial.retail.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class AccountRepositoryImpl implements AllLimited<Account> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Account> findAllLimitedTo(int limit) {
        return entityManager
                .createQuery("SELECT a FROM Account a", Account.class)
                .setMaxResults(limit)
                .getResultList();
    }
}
