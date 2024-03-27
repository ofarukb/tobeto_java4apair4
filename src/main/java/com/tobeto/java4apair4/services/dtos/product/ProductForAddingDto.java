package com.tobeto.java4apair4.services.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForAddingDto {
	private String name;
	private double price;
	private int categoryId;
}
