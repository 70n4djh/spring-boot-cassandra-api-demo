package com.jihaoduan.springbootcassandra.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.github.fge.jsonpatch.JsonPatch;
import com.jihaoduan.springbootcassandra.model.Product;

public interface ProductServiceInterface {
    public abstract Product createProduct(Product product);
    public abstract Product getProductById(UUID id) throws Exception;
    public abstract List<Product> getAllProducts();
    public abstract List<Product> getAllProductsByCategory(String category);
    public abstract List<Product> getAllProductsByBrand(String brand);
    public abstract Product updateProduct(UUID id, JsonPatch patch) throws Exception;
    public abstract void deleteProduct(UUID id) throws Exception;
}
