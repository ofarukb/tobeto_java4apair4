package com.tobeto.java4apair4.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.java4apair4.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	Optional<Product> findByName(String name);
}
