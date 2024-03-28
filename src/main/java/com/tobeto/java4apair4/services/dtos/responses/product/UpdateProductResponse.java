package com.tobeto.java4apair4.services.dtos.responses.product;

import java.time.LocalDateTime;

import com.tobeto.java4apair4.services.dtos.responses.category.ListCategoryResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {
	private int id;
	private String name;
	private double price;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private ListCategoryResponse category;
}
