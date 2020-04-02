package com.jihaoduan.springbootcassandra.api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.jihaoduan.springbootcassandra.model.Product;
import com.jihaoduan.springbootcassandra.repository.ProductRepository;
import com.jihaoduan.springbootcassandra.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import net.minidev.json.JSONObject;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/product", consumes = { "application/json" })
    public Product createProduct(@RequestBody @Valid Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping(path = "/product/{id}", consumes = { "application/json-patch+json" })
    public ResponseEntity<Product> updateProduct(@PathVariable("id") UUID id, @RequestBody @Valid JsonPatch patch) {

        try {
            Product product = productService.updateProduct(id, patch);
            return ResponseEntity.ok(product);
        } catch(ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping(path = "/product/{id}", produces = {"application/json"})
    public ResponseEntity<ProductOperationResonse> updateProduct(@PathVariable("id") UUID id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok(new ProductOperationResonse("Product Deleted", id));
        } catch(ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
