package com.tobeto.java4apair4.services.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForUpdatingDto {
	private int id;
	private String name;
	private double price;
}
