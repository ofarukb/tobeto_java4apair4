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

import com.tobeto.java4apair4.services.abstracts.CategoryService;
import com.tobeto.java4apair4.services.dtos.requests.category.AddCategoryRequest;
import com.tobeto.java4apair4.services.dtos.requests.category.UpdateCategoryRequest;
import com.tobeto.java4apair4.services.dtos.responses.category.AddCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.UpdateCategoryResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	public List<ListCategoryResponse> getAll() {
		return categoryService.getAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AddCategoryResponse add(@RequestBody @Valid AddCategoryRequest category) {
		return categoryService.add(category);
	}
	
	@PutMapping
	public UpdateCategoryResponse add(@RequestBody @Valid UpdateCategoryRequest category) {
		return categoryService.update(category);
	}

	@DeleteMapping
	public void delete(@RequestParam int id) {
		categoryService.deleteById(id);
	}
}
