package com.tobeto.java4apair4.services.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.entities.Product;
import com.tobeto.java4apair4.repositories.CategoryRepository;
import com.tobeto.java4apair4.repositories.ProductRepository;
import com.tobeto.java4apair4.services.abstracts.ProductService;
import com.tobeto.java4apair4.services.dtos.product.ProductForAddingDto;
import com.tobeto.java4apair4.services.dtos.product.ProductForListingDto;
import com.tobeto.java4apair4.services.dtos.product.ProductForUpdatingDto;
import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<ProductForListingDto> getAll() {
		List<Product> products = productRepository.findAll();
		List<ProductForListingDto> productForListingDtos = new ArrayList<ProductForListingDto>();

		// Product'lari map'le
		for (Product product : products) {
			// Önce Product'in Category'sini map'le
			Category categoryEntity = categoryRepository.findById(product.getCategory().getId())
					.orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
			ListCategoryResponse categoryForListingDto = new ListCategoryResponse(categoryEntity.getId(),
					categoryEntity.getName(), categoryEntity.getCreatedAt(), categoryEntity.getModifiedAt(),
					categoryEntity.getDeletedAt());
			ProductForListingDto productForListingDto = new ProductForListingDto(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), product.getDeletedAt(),
					categoryForListingDto);
			productForListingDtos.add(productForListingDto);
		}
		return productForListingDtos;
	}

	@Override
	public void add(ProductForAddingDto productForAddingDto) {
		// Product'i map'le
		Product product = new Product();
		product.setName(productForAddingDto.getName());
		product.setPrice(productForAddingDto.getPrice());
		// Category'sini map'le
		Category category = new Category();
		category.setId(productForAddingDto.getCategoryId());
		product.setCategory(category);
		productRepository.save(product);
	}

	@Override
	public void update(ProductForUpdatingDto productForUpdatingDto) {
		// Product'i map'le
		Product product = new Product();
		product.setName(productForUpdatingDto.getName());
		product.setPrice(productForUpdatingDto.getPrice());
		product.setId(productForUpdatingDto.getId());
		product.setModifiedAt(LocalDateTime.now());// tarih guncelle
		// Category'sini map'le
		int categoryId = productRepository.findById(productForUpdatingDto.getId())
				.orElseThrow(() -> new RuntimeException("Ürün bulunamadı")).getCategory().getId();
		Category category=new Category();
		category.setId(categoryId);
		product.setCategory(category);
		productRepository.save(product);
	}

	@Override
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}

}
