package com.tobeto.java4apair4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.java4apair4.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{

}
