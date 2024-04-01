package com.tobeto.java4apair4.controllers;

import java.time.LocalDateTime;
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
import com.tobeto.java4apair4.services.dtos.requests.product.AddProductRequest;
import com.tobeto.java4apair4.services.dtos.requests.product.UpdateProductRequest;
import com.tobeto.java4apair4.services.dtos.responses.product.AddProductResponse;
import com.tobeto.java4apair4.services.dtos.responses.product.ListProductResponse;
import com.tobeto.java4apair4.services.dtos.responses.product.UpdateProductResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping
	public List<ListProductResponse> getAll() {
		List<ListProductResponse> products = productService.getAll();
		return products;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AddProductResponse add(@RequestBody @Valid AddProductRequest request) {
		return productService.add(request);
	}

	@PutMapping
	public UpdateProductResponse update(@RequestBody @Valid UpdateProductRequest request) {
		return productService.update(request);
	}

	@DeleteMapping
	public void add(@RequestParam int id) {
		productService.deleteById(id);
	}
	
	@GetMapping("/getbyname")
	public List<ListProductResponse> getByName(@RequestParam String name) {
		List<ListProductResponse> products = productService.findByNameIgnoreCaseOrderByName(name);
		return products;
	}
	
	@GetMapping("/getbynamestartingwith")
	public List<ListProductResponse> getByNameStartingWith(@RequestParam String prefix) {
		List<ListProductResponse> products = productService.findByNameStartingWithIgnoreCaseOrderByName(prefix);
		return products;
	}
	
	@GetMapping("/getbynameendingwith")
	public List<ListProductResponse> getByNameEndingWith(@RequestParam String suffix) {
		List<ListProductResponse> products = productService.findByNameEndingWithIgnoreCaseOrderByName(suffix);
		return products;
	}
	
	@GetMapping("/getbynamecontaining")
	public List<ListProductResponse> getByNameContaining(@RequestParam String infix) {
		List<ListProductResponse> products = productService.findByNameContainingIgnoreCaseOrderByName(infix);
		return products;
	}
	
	@GetMapping("/getbynamelike")
	public List<ListProductResponse> getByNameLike(@RequestParam String likePattern) {
		List<ListProductResponse> products = productService.findByNameLikeOrderByName(likePattern);
		return products;
	}
	
	@GetMapping("/getbypricelessthan")
	public List<ListProductResponse> getByPriceLessThan(@RequestParam Integer price) {
		List<ListProductResponse> products = productService.findByPriceLessThan(price);
		return products;
	}
	
	@GetMapping("/getbycreatedatbefore")
	public List<ListProductResponse> getByCreatedAtBefore(@RequestParam LocalDateTime createdDate) {
		List<ListProductResponse> products = productService.findByCreatedAtBefore(createdDate);
		return products;
	}
	
	@GetMapping("/getbycategoryid")
	public List<ListProductResponse> getByCreatedAtBefore(@RequestParam Integer categoryId) {
		List<ListProductResponse> products = productService.findByCategoryId(categoryId);
		return products;
	}
	
}
