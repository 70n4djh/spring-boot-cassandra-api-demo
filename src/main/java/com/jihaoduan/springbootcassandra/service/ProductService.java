package com.jihaoduan.springbootcassandra.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.jihaoduan.springbootcassandra.model.Product;
import com.jihaoduan.springbootcassandra.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(UUID id) throws NoSuchElementException {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByCategory(String category) {
        return productRepository.findProductByCategory(category);
    }

    @Override
    public List<Product> getAllProductsByBrand(String brand) {
        return productRepository.findProductByBrand(brand);
    }

    @Override
    public void updateProduct(UUID id, Product product) throws NoSuchElementException {
        Product existingProduct = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(UUID id) throws NoSuchElementException {
        Product existingProduct = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        productRepository.delete(existingProduct);
    }




}
