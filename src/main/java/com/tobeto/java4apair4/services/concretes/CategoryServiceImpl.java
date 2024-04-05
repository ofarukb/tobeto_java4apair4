package com.tobeto.java4apair4.services.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.tobeto.java4apair4.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.repositories.CategoryRepository;
import com.tobeto.java4apair4.services.abstracts.CategoryService;
import com.tobeto.java4apair4.services.dtos.requests.category.AddCategoryRequest;
import com.tobeto.java4apair4.services.dtos.requests.category.UpdateCategoryRequest;
import com.tobeto.java4apair4.services.dtos.responses.category.AddCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.category.UpdateCategoryResponse;
import com.tobeto.java4apair4.services.mappers.CategoryMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	@Override
	public List<ListCategoryResponse> getAll() {
		List<Category> categories = categoryRepository.findAllOrderByIdAsc();
		List<ListCategoryResponse> response = new ArrayList<ListCategoryResponse>();

		// Category'leri map'le
		for (Category category : categories) {
			ListCategoryResponse listCategoryResponse = CategoryMapper.INSTANCE
					.listCategoryResponseFromCategory(category);
			response.add(listCategoryResponse);
		}
		return response;
	}

	@Override
	public AddCategoryResponse add(AddCategoryRequest request) {
		categoryWithSameNameShouldNotExist(request.getName());

		// Request'i Category'ye map'le
		Category category = CategoryMapper.INSTANCE.categoryFromAddRequest(request);

		Category savedCategory = categoryRepository.save(category);

		// Category'yi Response'a map'le
		AddCategoryResponse response = CategoryMapper.INSTANCE.addCategoryResponseFromCategory(savedCategory);

		return response;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest request) {
		categoryWithSameNameShouldNotExist(request.getName());
		categoryWithGivenIdShouldExist(request.getId());

		// Request'i Category'ye map'le
		Category category = CategoryMapper.INSTANCE.categoryFromUpdateCategoryRequest(request);
		category.setModifiedAt(LocalDateTime.now());
		Category savedCategory = categoryRepository.save(category);

		// Category'yi Response'a map'le
		UpdateCategoryResponse response = CategoryMapper.INSTANCE.updateCategoryResponseFromCategory(savedCategory);

		return response;
	}

	@Override
	public void deleteById(int id) {
		categoryRepository.deleteById(id);
	}

	// Aynı isimde bir kategori olmamali
	private void categoryWithSameNameShouldNotExist(String categoryName) {
		categoryRepository.findByName(categoryName).ifPresent((category) -> {
			throw new BusinessException(categoryName + " isimli bir kategori zaten var");
		});
	}

	// Verilen id'de bir kategori olmali
	private void categoryWithGivenIdShouldExist(int id) {
		categoryRepository.findById(id).orElseThrow(() -> new BusinessException("Kategori bulunamadı"));
	}

}
