package com.graphqljava.tutorial.retail.repository;

import com.graphqljava.tutorial.retail.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

	Optional<Product> findById(UUID id);

	List<Product> findAllLimitedTo(int limit);

}
