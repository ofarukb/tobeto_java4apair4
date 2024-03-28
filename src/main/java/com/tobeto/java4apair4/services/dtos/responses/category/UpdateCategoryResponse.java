package com.tobeto.java4apair4.services.dtos.responses.category;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryResponse {
	private int id;
	private String name;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
