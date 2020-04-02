package com.jihaoduan.springbootcassandra.model;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("product")
public class Product {

    @PrimaryKey
    @NotNull
    public UUID id;

    public String name;
    public int price;
    public String image;
    public String description;
    public String sellBy;
    public String brand;
    public String category;
    public Date createdAt;
    public Date lastUpdated;

    public Product() {
    }

    public Product(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Product(String name, int price, String image, String description, String sellBy, String brand, String category, Date createdAt, Date lastUpdated) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.sellBy = sellBy;
        this.brand = brand;
        this.category = category;
        this.createdAt = createdAt;
        this.lastUpdated = lastUpdated;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellBy() {
        return this.sellBy;
    }

    public void setSellBy(String sellBy) {
        this.sellBy = sellBy;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && price == product.price && Objects.equals(image, product.image) && Objects.equals(description, product.description) && Objects.equals(sellBy, product.sellBy) && Objects.equals(brand, product.brand) && Objects.equals(category, product.category) && Objects.equals(createdAt, product.createdAt) && Objects.equals(lastUpdated, product.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", image='" + getImage() + "'" +
            ", description='" + getDescription() + "'" +
            ", sellBy='" + getSellBy() + "'" +
            ", brand='" + getBrand() + "'" +
            ", category='" + getCategory() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", lastUpdated='" + getLastUpdated() + "'" +
            "}";
    }
}
