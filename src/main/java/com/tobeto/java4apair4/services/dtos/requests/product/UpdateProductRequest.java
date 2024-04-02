package com.tobeto.java4apair4.services.dtos.requests.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
	@Min(value = 1, message = "Ürün Id'si belli degil")
	private int id;
	@NotBlank
	@Size(min = 2, message = "Ürün adı en az 2 karakter olmalı")
	private String name;
	@PositiveOrZero(message = "Ürün fiyatı negatif deger alamaz")
	private double price;
}
