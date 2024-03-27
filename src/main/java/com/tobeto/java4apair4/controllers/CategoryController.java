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
import com.tobeto.java4apair4.services.dtos.category.CategoryForAddingDto;
import com.tobeto.java4apair4.services.dtos.category.CategoryForListingDto;
import com.tobeto.java4apair4.services.dtos.category.CategoryForUpdatingDto;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	public List<CategoryForListingDto> getAll() {
		return categoryService.getAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CategoryForAddingDto category) {
		categoryService.add(category);
	}
	
	@PutMapping
	public void add(@RequestBody CategoryForUpdatingDto category) {
		categoryService.update(category);
	}

	@DeleteMapping
	public void delete(@RequestParam int id) {
		categoryService.deleteById(id);
	}
}
