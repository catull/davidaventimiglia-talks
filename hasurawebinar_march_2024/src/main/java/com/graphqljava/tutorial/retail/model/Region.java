package com.graphqljava.tutorial.retail.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"region\"")
public class Region {

    public Region() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "value", updatable = false)
    private String value;

    @Column(name = "description", updatable = false)
    private String description;

    public void setValue(final String name) {
        this.value = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Region {"
                + "name: " + this.value
                + ", "
                + "description: " + this.description
                + "}";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String value;
        private String description;

        public Builder withValue(final String valueParam) {
            this.value = valueParam;
            return this;
        }

        public Builder withDescription(final String descriptionParam) {
            this.description = descriptionParam;
            return this;
        }

        public Region build() {
            Region region = new Region();
            region.setValue(this.value);
            region.setDescription(this.description);

            return region;
        }
    }
}
