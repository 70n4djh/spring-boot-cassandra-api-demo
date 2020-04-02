package com.jihaoduan.springbootcassandra.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.jihaoduan.springbootcassandra.model.Product;

public interface ProductServiceInterface {
    public abstract Product createProduct(Product product);
    public abstract Product getProductById(UUID id) throws NoSuchElementException;
    public abstract List<Product> getAllProducts();
    public abstract List<Product> getAllProductsByCategory(String category);
    public abstract List<Product> getAllProductsByBrand(String brand);
    public abstract void updateProduct(UUID id, Product product) throws NoSuchElementException;
    public abstract void deleteProduct(UUID id) throws NoSuchElementException;
}
