package com.tobeto.java4apair4.services.dtos.requests.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
	@NotBlank
	@Size(min = 2, message = "Ürün adı en az 2 karakter olmalı")
	private String name;
	@Min(value = 0, message = "Ürün fiyatı negatif deger alamaz")
	private double price;
	@Min(value = 1,message = "Lütfen ürün kategorisini belirleyin")
	private int categoryId;
}
