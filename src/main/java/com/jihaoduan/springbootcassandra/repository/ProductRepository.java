package com.jihaoduan.springbootcassandra.repository;

import java.util.List;
import java.util.UUID;

import com.jihaoduan.springbootcassandra.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<Product, UUID> {
    List<Product> findProductByBrand(String brand);
    List<Product> findProductByCategory(String category);
}
