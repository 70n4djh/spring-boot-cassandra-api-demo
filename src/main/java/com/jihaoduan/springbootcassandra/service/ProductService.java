package com.jihaoduan.springbootcassandra.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.jihaoduan.springbootcassandra.model.Product;
import com.jihaoduan.springbootcassandra.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface {

    private ProductRepository productRepository;
    private ObjectMapper objectMapper = new ObjectMapper();


    private Product applyPatch(JsonPatch patch, Product target) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(target, JsonNode.class));
        return objectMapper.treeToValue(patched, Product.class);
    }

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        if(product.getId() == null) product.setId(UUID.randomUUID());
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(UUID id) throws ResourceNotFoundException {
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
    public Product updateProduct(UUID id, JsonPatch patch) throws ResourceNotFoundException, JsonPatchException, JsonProcessingException {
        Product existingProduct = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        Product patchedProduct = applyPatch(patch, existingProduct);
        return productRepository.save(patchedProduct);
    }

    @Override
    public void deleteProduct(UUID id) throws ResourceNotFoundException {
        Product existingProduct = productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        productRepository.delete(existingProduct);
    }




}
