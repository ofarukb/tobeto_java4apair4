package com.tobeto.java4apair4.services.abstracts;

import java.util.List;

import com.tobeto.java4apair4.services.dtos.category.CategoryForAddingDto;
import com.tobeto.java4apair4.services.dtos.category.CategoryForListingDto;
import com.tobeto.java4apair4.services.dtos.category.CategoryForUpdatingDto;

public interface CategoryService {
	List<CategoryForListingDto> getAll();
	void add(CategoryForAddingDto categoryForAddingDto);
	void update(CategoryForUpdatingDto categoryForUpdatingDto);
	void deleteById(int id);
}
