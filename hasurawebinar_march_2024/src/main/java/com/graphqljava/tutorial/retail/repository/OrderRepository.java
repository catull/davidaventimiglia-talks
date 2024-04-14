package com.graphqljava.tutorial.retail.repository;

import com.graphqljava.tutorial.retail.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID>, AllLimited<Order> {

	Optional<Order> findById(final UUID id);

	List<Order> findAllByAccountId(final UUID accountId);
}
