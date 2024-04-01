package com.tobeto.java4apair4.services.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.entities.Product;
import com.tobeto.java4apair4.repositories.CategoryRepository;
import com.tobeto.java4apair4.repositories.ProductRepository;
import com.tobeto.java4apair4.services.abstracts.ProductService;
import com.tobeto.java4apair4.services.dtos.requests.product.AddProductRequest;
import com.tobeto.java4apair4.services.dtos.requests.product.UpdateProductRequest;
import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4apair4.services.dtos.responses.product.AddProductResponse;
import com.tobeto.java4apair4.services.dtos.responses.product.ListProductResponse;
import com.tobeto.java4apair4.services.dtos.responses.product.UpdateProductResponse;

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
	public List<ListProductResponse> getAll() {
		List<Product> products = productRepository.findAll();
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'lari map'le
		for (Product product : products) {
			// Önce Product'in Category'sini map'le
			Category category = categoryRepository.findById(product.getCategory().getId())
					.orElseThrow(() -> new RuntimeException("Kategori bulunamadı"));
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public AddProductResponse add(AddProductRequest request) {
		productWithSameNameShouldNotExist(request.getName());

		// Request'ten Product'a map'le
		Product product = new Product();
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		// Request'in Category'sini map'le
		Category category = categoryRepository.findById(request.getCategoryId())
				.orElseThrow(() -> new RuntimeException("Kategori bulunamadi"));
		product.setCategory(category);
		Product savedProduct = productRepository.save(product);

		// Product'i Response'a map'le
		// Önce Category'sini map'le
		ListCategoryResponse categoryResponse = new ListCategoryResponse(savedProduct.getCategory().getId(),
				savedProduct.getCategory().getName(), savedProduct.getCategory().getCreatedAt(),
				savedProduct.getCategory().getModifiedAt());
		AddProductResponse response = new AddProductResponse(savedProduct.getId(), savedProduct.getName(),
				savedProduct.getPrice(), savedProduct.getCreatedAt(), categoryResponse);
		return response;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest request) {
		productWithSameNameShouldNotExist(request.getName());

		// Request'ten Product'a map'le
		Product product = productRepository.findById(request.getId())
				.orElseThrow(() -> new RuntimeException("Urun bulunamadi"));
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setModifiedAt(LocalDateTime.now());// tarih guncelle
		Product savedProduct = productRepository.save(product);

		// Product'i Response'a map'le
		ListCategoryResponse categoryResponse = new ListCategoryResponse(savedProduct.getCategory().getId(),
				savedProduct.getCategory().getName(), savedProduct.getCategory().getCreatedAt(),
				savedProduct.getCategory().getModifiedAt());
		UpdateProductResponse response = new UpdateProductResponse(savedProduct.getId(), savedProduct.getName(),
				savedProduct.getPrice(), savedProduct.getCreatedAt(), savedProduct.getModifiedAt(), categoryResponse);
		return response;
	}

	@Override
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<ListProductResponse> findByNameStartingWithIgnoreCaseOrderByName(String prefix) {
		List<Product> products = productRepository.findByNameStartingWithIgnoreCaseOrderByName(prefix);
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public List<ListProductResponse> findByNameIgnoreCaseOrderByName(String name) {
		List<Product> products = productRepository.findByNameIgnoreCaseOrderByName(name);
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public List<ListProductResponse> findByNameEndingWithIgnoreCaseOrderByName(String suffix) {
		List<Product> products = productRepository.findByNameEndingWithIgnoreCaseOrderByName(suffix);
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public List<ListProductResponse> findByNameContainingIgnoreCaseOrderByName(String infix) {
		List<Product> products = productRepository.findByNameContainingIgnoreCaseOrderByName(infix);
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public List<ListProductResponse> findByNameLikeOrderByName(String likePattern) {
		List<Product> products = productRepository.findByNameLikeOrderByName(likePattern);
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public List<ListProductResponse> findByPriceLessThan(Integer price) {
		List<Product> products = productRepository.findByPriceLessThan(price);
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public List<ListProductResponse> findByCreatedAtBefore(LocalDateTime createdDate) {
		List<Product> products = productRepository.findByCreatedAtBefore(createdDate);
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();

		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	@Override
	public List<ListProductResponse> findByCategoryId(Integer categoryId) {
		List<ListProductResponse> response = new ArrayList<ListProductResponse>();
//		Category nesnesi ile aranacaksa
//		Optional<Category> c = categoryRepository.findById(categoryId);
//		if (c.isEmpty())
//			return response;
//		List<Product> products = productRepository.findByCategory(c.orElseThrow());
		
		List<Product> products = productRepository.findByCategoryId(categoryId);
		// Product'i Response'a map'le
		for (Product product : products) {
			// Once Category'sini map'le
			Category category = product.getCategory();
			ListCategoryResponse listCategoryResponse = new ListCategoryResponse(category.getId(), category.getName(),
					category.getCreatedAt(), category.getModifiedAt());
			ListProductResponse listProductResponse = new ListProductResponse(product.getId(), product.getName(),
					product.getPrice(), product.getCreatedAt(), product.getModifiedAt(), listCategoryResponse);
			response.add(listProductResponse);
		}
		return response;
	}

	// Aynı isimde ürün olup olmadigini kontrol et
	private void productWithSameNameShouldNotExist(String productName) {
		Optional<Product> productWithSameName = productRepository.findByName(productName);
		if (productWithSameName.isPresent()) {
			throw new RuntimeException(productName + " isimli bir ürün zaten var");
		}
	}
}
