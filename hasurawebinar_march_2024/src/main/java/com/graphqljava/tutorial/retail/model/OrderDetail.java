package com.graphqljava.tutorial.retail.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "\"orderDetail\"")
public class OrderDetail
{
	public OrderDetail() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "createdAt", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@Column(name = "updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@Column(name = "product_id")
	private UUID productId;

	@Column(name = "order_id")
	private UUID orderId;

	private Integer units;

	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

	public void setId(final UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return this.id;
	}

	public void setCreatedAt(final LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getCreatedAt() {
		return this.createdAt;
	}

	public void setUpdatedAt(final LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getUpdatedAt() {
		return this.updatedAt;
	}

	public void setProductId(final UUID productId) {
		this.productId = productId;
	}

	public UUID getProductId() {
		return this.productId;
	}

	public void setOrderId(final UUID orderId) {
		this.orderId = orderId;
	}

	public UUID getOrderId() {
		return this.orderId;
	}

	public void setUnits(final Integer units) {
		this.units = units;
	}

	public Integer getUnits() {
		return this.units;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setOrder(final Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return this.order;
	}

     public String toString() {
        return "OrderDetail {"
				+ "id: " + this.id
				+ ", "
				+ "createdAt: " + this.createdAt
				+ ", "
				+ "updatedAt: " + this.updatedAt
				+ ", "
				+ "productId: " + this.productId
				+ ", "
				+ "orderId: " + this.orderId
				+ ", "
				+ "units: " + this.units
        		+ "}";
    }

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private UUID id;
		private LocalDateTime createdAt;
		private LocalDateTime updatedAt;
		private UUID productId;
		private Product product;
		private UUID orderId;
		private Order order;
		private Integer units;

		public Builder withId(final UUID idParam) {
			this.id = idParam;
			return this;
		}

		public Builder withCreatedAt(final LocalDateTime createdAtParam) {
			this.createdAt = createdAtParam;
			return this;
		}

		public Builder withUpdatedAt(final LocalDateTime updatedAtParam) {
			this.updatedAt = updatedAtParam;
			return this;
		}

		public Builder withProductId(final UUID productIdParam) {
			this.productId = productIdParam;
			return this;
		}

		public Builder withProduct(final Product productParam) {
			this.product = productParam;
			return this;
		}

		public Builder withOrderId(final UUID orderIdParam) {
			this.orderId = orderIdParam;
			return this;
		}

		public Builder withOrder(final Order orderParam) {
			this.order = orderParam;
			return this;
		}

		public Builder withUnits(final Integer unitsParam) {
			this.units = unitsParam;
			return this;
		}

		public OrderDetail build() {
			OrderDetail detail = new OrderDetail();
			detail.setId(this.id);
			detail.setCreatedAt(this.createdAt);
			detail.setUpdatedAt(this.updatedAt);
			detail.setProductId(this.productId);
			detail.setProduct(this.product);
			detail.setOrderId(this.orderId);
			detail.setOrder(this.order);
			detail.setUnits(this.units);

			return detail;
		}
	}
}
