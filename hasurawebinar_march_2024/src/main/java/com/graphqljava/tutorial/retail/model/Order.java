package com.graphqljava.tutorial.retail.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"order\"")
public class Order {
    public Order() {
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

    @Column(name = "account_id")
    private UUID accountId;

    private String status;

    private String region;

    @Transient
    private Account account;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
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

    public void setAccountId(final UUID accountId) {
        this.accountId = accountId;
    }

    public UUID getAccountId() {
        return this.accountId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public String getRegion() {
        return this.region;
    }

    public void setAccount(final Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public List<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String toString() {
        return "Order {"
                + "id: " + this.id
                + ", "
                + "createdAt: " + this.createdAt
                + ", "
                + "updatedAt: " + this.updatedAt
                + ", "
                + "accountId: " + this.accountId
                + ", "
                + "status: " + this.status
                + ", "
                + "region: " + this.region
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
        private UUID accountId;
        private String status;
        private String region;
        private Account account;
        public List<OrderDetail> orderDetails;

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

        public Builder withAccountId(final UUID accountIdParam) {
            this.accountId = accountIdParam;
            return this;
        }

        public Builder withAccount(final Account accountParam) {
            this.account = accountParam;
            return this;
        }

        public Builder withStatus(final String statusParam) {
            this.status = statusParam;
            return this;
        }

        public Builder withRegion(final String regionParam) {
            this.region = regionParam;
            return this;
        }

        public Builder withOrderDetails(final List<OrderDetail> orderDetails) {
            this.orderDetails = orderDetails;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.setId(this.id);
            order.setCreatedAt(this.createdAt);
            order.setUpdatedAt(this.updatedAt);
            order.setAccountId(this.accountId);
            order.setAccount(this.account);
            order.setStatus(this.status);
            order.setRegion(this.region);
            order.setOrderDetails(this.orderDetails);

            return order;
        }
    }
}
