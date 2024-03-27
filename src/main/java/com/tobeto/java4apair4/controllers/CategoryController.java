package com.tobeto.java4apair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@GetMapping
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@PostMapping
	public String add(@RequestBody Category category) {
		categoryRepository.save(category);
		return category.getName() + " isimli kategori eklendi.";
	}

	@DeleteMapping
	public String delete(@RequestParam int id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
		categoryRepository.delete(category);
		return category.getName() + " isimli kategori silindi.";
	}
}
