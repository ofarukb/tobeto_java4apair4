package com.tobeto.java4aPair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4aPair4.entities.Product;
import com.tobeto.java4aPair4.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	@PostMapping
    public String add(@RequestBody Product product)
    {
        productRepository.save(product);
        return "Ürün başarıyla Eklendi.";
    }
}
