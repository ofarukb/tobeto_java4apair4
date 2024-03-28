package com.tobeto.java4apair4.services.abstracts;

import java.util.List;

import com.tobeto.java4apair4.services.dtos.requests.category.AddCategoryRequest;
import com.tobeto.java4apair4.services.dtos.requests.category.UpdateCategoryRequest;
import com.tobeto.java4apair4.services.dtos.responses.category.AddCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.UpdateCategoryResponse;

public interface CategoryService {
	List<ListCategoryResponse> getAll();
	AddCategoryResponse add(AddCategoryRequest categoryForAddingDto);
	UpdateCategoryResponse update(UpdateCategoryRequest categoryForUpdatingDto);
	void deleteById(int id);
}
