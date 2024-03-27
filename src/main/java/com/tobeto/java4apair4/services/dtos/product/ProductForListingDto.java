package com.tobeto.java4apair4.services.dtos.product;

import java.time.LocalDateTime;

import com.tobeto.java4apair4.services.dtos.category.CategoryForListingDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForListingDto {
	private int id;
	private String name;
	private double price;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	private LocalDateTime deletedAt;
	private CategoryForListingDto category;
}
