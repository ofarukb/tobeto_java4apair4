package com.tobeto.java4apair4.services.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.repositories.CategoryRepository;
import com.tobeto.java4apair4.services.abstracts.CategoryService;
import com.tobeto.java4apair4.services.dtos.requests.category.AddCategoryRequest;
import com.tobeto.java4apair4.services.dtos.requests.category.UpdateCategoryRequest;
import com.tobeto.java4apair4.services.dtos.responses.category.AddCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.UpdateCategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<ListCategoryResponse> getAll() {
		List<Category> categories = categoryRepository.findAll();
		List<ListCategoryResponse> response = new ArrayList<ListCategoryResponse>();

		// Category'leri map'le
		for (Category category : categories) {
			ListCategoryResponse categoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			response.add(categoryResponse);
		}
		return response;
	}

	@Override
	public AddCategoryResponse add(AddCategoryRequest request) {
		// Request'i Category'ye map'le
		Category category = new Category();
		category.setName(request.getName());
		category.setCreatedAt(LocalDateTime.now());
		Category savedCategory = categoryRepository.save(category);

		// Category'yi Response'a map'le
		AddCategoryResponse response = new AddCategoryResponse(savedCategory.getId(), savedCategory.getName(),
				savedCategory.getCreatedAt());
		return response;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest request) {
		// Request'i Category'ye map'le
		Category category = categoryRepository.findById(request.getId())
				.orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
		category.setName(request.getName());
		category.setModifiedAt(LocalDateTime.now());
		Category savedCategory = categoryRepository.save(category);

		// Category'yi Response'a map'le
		UpdateCategoryResponse response = new UpdateCategoryResponse(savedCategory.getId(), savedCategory.getName(),
				savedCategory.getCreatedAt(), savedCategory.getModifiedAt());

		return response;
	}

	@Override
	public void deleteById(int id) {
		categoryRepository.deleteById(id);
	}

}
