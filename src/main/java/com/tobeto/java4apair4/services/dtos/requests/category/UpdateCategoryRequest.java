package com.tobeto.java4apair4.services.dtos.requests.category;

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
public class UpdateCategoryRequest {
	@Min(value = 1, message = "Kategori belirtilmemis.")
	private int id;
	@NotBlank
	@Size(min = 2, message = "Kategori adi en az 2 karakterden olusmali.")
	private String name;
}
