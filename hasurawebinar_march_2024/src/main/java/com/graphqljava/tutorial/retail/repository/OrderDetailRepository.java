package com.graphqljava.tutorial.retail.repository;

import com.graphqljava.tutorial.retail.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID>, AllLimited<OrderDetail> {

	Optional<OrderDetail> findById(final UUID id);

	List<OrderDetail> findByIdIn(final List<UUID> ids);

	List<OrderDetail> findAllByProductId(final UUID product_id);

}
