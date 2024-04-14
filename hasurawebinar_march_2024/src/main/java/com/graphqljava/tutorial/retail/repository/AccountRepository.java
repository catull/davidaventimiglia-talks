package com.graphqljava.tutorial.retail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.graphqljava.tutorial.retail.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>, AllLimited<Account> {

	Optional<Account> findById(final UUID id);

}
