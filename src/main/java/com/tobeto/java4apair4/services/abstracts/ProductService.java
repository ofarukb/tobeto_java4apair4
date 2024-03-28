package com.tobeto.java4apair4.services.abstracts;

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
}
