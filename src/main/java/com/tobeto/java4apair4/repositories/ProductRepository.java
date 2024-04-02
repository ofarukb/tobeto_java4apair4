package com.tobeto.java4apair4.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tobeto.java4apair4.entities.Category;
import com.tobeto.java4apair4.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	// Derived query methods
	Optional<Product> findByName(String name);
	Optional<Product> findByNameIgnoreCase(String name);

	List<Product> findByNameIgnoreCaseOrderByName(String name);

	List<Product> findByNameStartingWithIgnoreCaseOrderByName(String prefix);

	List<Product> findByNameEndingWithIgnoreCaseOrderByName(String suffix);

	List<Product> findByNameContainingIgnoreCaseOrderByName(String infix);

	/**
	 * @param likePattern Ornek: "a%b%c" --> a ile baslayan, b iceren ve c ile biten
	 *                    <code>Product</code> kayitlari
	 * @return pattern'e uyan kayitlar, isme gore siralanmis sekilde
	 */
	List<Product> findByNameLikeOrderByName(String likePattern);

	List<Product> findByPriceLessThan(Integer price);

	List<Product> findByCreatedAtBefore(LocalDateTime createdDate);

	// Custom Queries
	@Query("SELECT p FROM Product p WHERE p.category = ?1")
	List<Product> findByCategory(Category category);

	@Query(value = "SELECT p.* FROM products p WHERE p.category_id = ?", nativeQuery = true)
	List<Product> findByCategoryId(Integer categoryId);
}
