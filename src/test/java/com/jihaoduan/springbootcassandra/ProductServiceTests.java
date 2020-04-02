package com.jihaoduan.springbootcassandra;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;
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
		Product product = new Product("Apples");
		when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
		productService.deleteProduct(product.getId());
		verify(productRepository, times(1)).delete(product);
	}

	@Test
	public void testGetProductById() {
		Product product = new Product("Apples");
		when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
		assertEquals(product, productService.getProductById(product.getId()));
	}

	@Test
    public void testGetProductByInvalidId() {
		UUID randomId = UUID.randomUUID();
		when(productRepository.findById(randomId)).thenThrow(new NoSuchElementException());
		assertThrows(NoSuchElementException.class, () -> productService.getProductById(randomId));
	}

	@Test
	public void testUpdateProductName() {
		Product product = new Product("Apples");
		product.setName("Oranges");
		when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
		productService.updateProduct(product.getId(), product);
		verify(productRepository, times(1)).save(product);
	}

	@Test
	public void testUpdateProductPrice() {
		Product product = new Product("Apples");
		product.setPrice(1200);
		when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
		productService.updateProduct(product.getId(), product);
		verify(productRepository, times(1)).save(product);
	}

}
