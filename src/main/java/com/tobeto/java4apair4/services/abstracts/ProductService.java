package com.tobeto.java4apair4.services.abstracts;

import java.util.List;

import com.tobeto.java4apair4.services.dtos.product.ProductForAddingDto;
import com.tobeto.java4apair4.services.dtos.product.ProductForListingDto;
import com.tobeto.java4apair4.services.dtos.product.ProductForUpdatingDto;

public interface ProductService {
	List<ProductForListingDto> getAll();
	void add(ProductForAddingDto productForAddingDto);
	void update(ProductForUpdatingDto productForUpdatingDto);
	void deleteById(int id);
}
