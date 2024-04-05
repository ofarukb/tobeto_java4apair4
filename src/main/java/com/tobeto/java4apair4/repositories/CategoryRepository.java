package com.tobeto.java4apair4.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tobeto.java4apair4.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findByName(String categoryName);
	
	@Query("SELECT c FROM Category c ORDER BY id")
	List<Category> findAllOrderByIdAsc();

}
