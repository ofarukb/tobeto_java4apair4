package com.tobeto.java4apair4.services.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.repositories.CategoryRepository;
import com.tobeto.java4apair4.services.abstracts.CategoryService;
import com.tobeto.java4apair4.services.dtos.category.CategoryForAddingDto;
import com.tobeto.java4apair4.services.dtos.category.CategoryForListingDto;
import com.tobeto.java4apair4.services.dtos.category.CategoryForUpdatingDto;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryForListingDto> getAll() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryForListingDto> categoryForListingDtos = new ArrayList<CategoryForListingDto>();

		// Category'leri map'le
		for (Category category : categories) {
			CategoryForListingDto categoryForListingDto = new CategoryForListingDto(category.getId(),
					category.getName(), category.getCreatedAt(), category.getModifiedAt(), category.getDeletedAt());
			categoryForListingDtos.add(categoryForListingDto);
		}
		return categoryForListingDtos;
	}

	@Override
	public void add(CategoryForAddingDto categoryForAddingDto) {
		// Category'yi map'le
		Category category = new Category();
		category.setName(categoryForAddingDto.getName());
		categoryRepository.save(category);
	}

	@Override
	public void update(CategoryForUpdatingDto categoryForUpdatingDto) {
		// Category'yi map'le
		Category category = new Category();
		category.setId(categoryForUpdatingDto.getId());
		category.setName(categoryForUpdatingDto.getName());
		categoryRepository.save(category);
	}

	@Override
	public void deleteById(int id) {
		categoryRepository.deleteById(id);
	}

}
