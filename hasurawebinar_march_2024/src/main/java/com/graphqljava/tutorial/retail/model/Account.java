package com.graphqljava.tutorial.retail.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.List;

@Entity
@Table(name = "\"account\"")
public class Account {

    public Account() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String name;

    @Transient
    @OneToMany(mappedBy = "Account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

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

    public void setOrders(final List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public String toString() {
        return "Account {"
                + "id: " + this.id
                + ", "
                + "createdAt: " + this.createdAt
                + ", "
                + "updatedAt: " + this.updatedAt
                + ", "
                + "name: " + this.name
                + ", "
                + "orders: " + this.orders
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
        private List<Order> orders;

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

        public Builder withOrders(final List<Order> ordersParam) {
            this.orders = ordersParam;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(this.id);
            account.setCreatedAt(this.createdAt);
            account.setUpdatedAt(this.updatedAt);
            account.setName(this.name);
            account.setOrders(this.orders);

            return account;
        }
    }
}
