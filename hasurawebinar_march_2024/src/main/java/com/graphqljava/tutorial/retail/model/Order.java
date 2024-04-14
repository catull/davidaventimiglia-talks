package com.graphqljava.tutorial.retail.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;
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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(name = "account_id")
    private UUID accountId;

    private String status;

    @Transient
    private Account account;

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

    public void setAccount(final Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
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
        private Account account;

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

        public Order build() {
            Order order = new Order();
            order.setId(this.id);
            order.setCreatedAt(this.createdAt);
            order.setUpdatedAt(this.updatedAt);
            order.setAccountId(this.accountId);
            order.setAccount(this.account);
            order.setStatus(this.status);

            return order;
        }
    }
}
