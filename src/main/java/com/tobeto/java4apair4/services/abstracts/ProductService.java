package com.tobeto.java4apair4.services.abstracts;

import java.time.LocalDateTime;
import java.util.List;

import com.tobeto.java4apair4.services.dtos.requests.product.AddProductRequest;
import com.tobeto.java4apair4.services.dtos.requests.product.UpdateProductRequest;
import com.tobeto.java4apair4.services.dtos.responses.product.AddProductResponse;
import com.tobeto.java4apair4.services.dtos.responses.product.ListProductResponse;
import com.tobeto.java4apair4.services.dtos.responses.product.UpdateProductResponse;

public interface ProductService {
	List<ListProductResponse> getAll();

	AddProductResponse add(AddProductRequest request);

	UpdateProductResponse update(UpdateProductRequest request);

	void deleteById(int id);

	// Derived query methods
	List<ListProductResponse> findByNameIgnoreCaseOrderByName(String name);

	List<ListProductResponse> findByNameStartingWithIgnoreCaseOrderByName(String prefix);

	List<ListProductResponse> findByNameEndingWithIgnoreCaseOrderByName(String suffix);

	List<ListProductResponse> findByNameContainingIgnoreCaseOrderByName(String infix);

	/**
	 * @param likePattern Ornek: "a%b%c" --> a ile baslayan, b iceren ve c ile biten
	 *                    <code>Product</code> kayitlari
	 * @return pattern'e uyan kayitlar, isme gore siralanmis sekilde
	 */
	List<ListProductResponse> findByNameLikeOrderByName(String likePattern);

	List<ListProductResponse> findByPriceLessThan(Integer price);

	List<ListProductResponse> findByCreatedAtBefore(LocalDateTime createdDate);

	// Custom Query
	List<ListProductResponse> findByCategoryId(Integer category);
}
