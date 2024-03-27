package com.tobeto.java4apair4.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4apair4.services.abstracts.ProductService;
import com.tobeto.java4apair4.services.dtos.product.ProductForAddingDto;
import com.tobeto.java4apair4.services.dtos.product.ProductForListingDto;
import com.tobeto.java4apair4.services.dtos.product.ProductForUpdatingDto;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping
	public List<ProductForListingDto> getAll() {
		List<ProductForListingDto> products = productService.getAll();
		return products;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody ProductForAddingDto product) {
		productService.add(product);
	}

	@PutMapping
	public void update(@RequestBody ProductForUpdatingDto product) {
		productService.update(product);
	}

	@DeleteMapping
	public void add(@RequestParam int id) {
		productService.deleteById(id);
	}
}
