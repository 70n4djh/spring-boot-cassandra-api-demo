package com.jihaoduan.springbootcassandra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.jihaoduan.springbootcassandra.api.ProductController;
import com.jihaoduan.springbootcassandra.model.Product;
import com.jihaoduan.springbootcassandra.repository.ProductRepository;
import com.jihaoduan.springbootcassandra.service.ProductService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductService.class)
public class ProductServiceTests {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@Test
	public void testGetAllProducts() throws Exception {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
		assertEquals(0, productService.getAllProducts().size());
	}

	@Test
	public void testCreateProduct() {
		Product product = new Product("Apples");
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.createProduct(product));
	}

	@Test
	public void testDeleteProduct() throws Exception {

	}

	@Test
	public void testGetProductById() {

	}

	@Test
    public void testGetProductByInvalidId() {

	}

	@Test
	public void testUpdateProductName() {

	}

	// void testUpdateProductPrice() {

	// }

}
