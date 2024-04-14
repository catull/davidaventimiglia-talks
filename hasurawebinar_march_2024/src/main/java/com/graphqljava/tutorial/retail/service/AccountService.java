package com.graphqljava.tutorial.retail.service;

import com.graphqljava.tutorial.retail.repository.AccountRepository;
import com.graphqljava.tutorial.retail.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(final UUID id) {
        return this.accountRepository.findById(id).orElse(null);
    }

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    public List<Account> getAllAccountsLimitedTo(final int limit) {
        return this.accountRepository.findAllLimitedTo(limit);
    }

    public Account createAccount(final Account account) {
        return this.accountRepository.save(account);
    }

    public void deleteAccountById(final UUID id) {
        this.accountRepository.deleteById(id);
    }
}
