package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.model.Order;
import com.graphqljava.tutorial.retail.repository.AccountRepository;
import com.graphqljava.tutorial.retail.model.Account;
import com.graphqljava.tutorial.retail.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;

    public AccountService(
            final AccountRepository accountRepository,
            final OrderRepository orderRepository) {
        this.accountRepository = accountRepository;
        this.orderRepository = orderRepository;
    }

    public Account getAccountById(final UUID id) {
        Account account = this.accountRepository.findById(id).orElse(null);

        if (null == account) {
            return null;
        }

        List<Order> orders = this.orderRepository.findAllByAccountId(id);
        account.setOrders(orders);

        return account;
    }

    public List<Account> getAllAccounts() {
        return enhanceAccounts(this.accountRepository.findAll());
    }

    public List<Account> getAllAccountsLimitedTo(final int limit) {
        return enhanceAccounts(this.accountRepository.findAllLimitedTo(limit));
    }

    private List<Account> enhanceAccounts(final List<Account> accounts) {
        for (Account account : accounts) {
            account.setOrders(this.orderRepository.findAllByAccountId(account.getId()));
        }

        return accounts;
    }

    public Account createAccount(final Account account) {
        return this.accountRepository.save(account);
    }

    public void deleteAccountById(final UUID id) {
        this.accountRepository.deleteById(id);
    }
}
