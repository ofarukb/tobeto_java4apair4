package com.tobeto.java4apair4.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.services.dtos.requests.category.AddCategoryRequest;
import com.tobeto.java4apair4.services.dtos.requests.category.UpdateCategoryRequest;
import com.tobeto.java4apair4.services.dtos.responses.category.AddCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.UpdateCategoryResponse;

@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	Category categoryFromAddRequest(AddCategoryRequest request);

	AddCategoryResponse addCategoryResponseFromCategory(Category category);

	ListCategoryResponse listCategoryResponseFromCategory(Category category);

	Category categoryFromUpdateCategoryRequest(UpdateCategoryRequest request);

	UpdateCategoryResponse updateCategoryResponseFromCategory(Category category);
}
