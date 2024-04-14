package com.graphqljava.tutorial.retail.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;

@Entity
@Table(name = "\"product\"")
public class Product
{

	public Product() {
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

	private String name;

	private Integer price;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private List<OrderDetail> orderDetails;

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

	public void setName(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(final Integer price) {
		this.price = price;
	}

	public Integer getPrice() {
		return this.price;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String toString() {
        return "Product {"
				+ "id: " + this.id
				+ ", "
				+ "createdAt: " + this.createdAt
				+ ", "
				+ "updatedAt: " + this.updatedAt
				+ ", "
				+ "name: " + this.name
				+ ", "
				+ "price: " + this.price
				+ ", "
				+ "orderDetails: " + this.orderDetails
        		+ "}";
    }

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private UUID id;
		private LocalDateTime createdAt;
		private LocalDateTime updatedAt;
		private String name;
		private Integer price;
		private List<OrderDetail> orderDetails;

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

		public Builder withName(final String nameParam) {
			this.name = nameParam;
			return this;
		}

		public Builder withPrice(final Integer priceParam) {
			this.price = priceParam;
			return this;
		}

		public Builder withOrderDetails(final List<OrderDetail> orderDetailsParam) {
			this.orderDetails = orderDetailsParam;
			return this;
		}

		public Product build() {
			Product product = new Product();
			product.setId(this.id);
			product.setCreatedAt(this.createdAt);
			product.setUpdatedAt(this.updatedAt);
			product.setName(this.name);
			product.setPrice(this.price);
			product.setOrderDetails(this.orderDetails);

			return product;
		}
	}
}
