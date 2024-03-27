package com.tobeto.java4apair4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "categories")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "created_at")
	@Generated
	private LocalDateTime created_at;

	@Column(name = "modified_at")
	private LocalDateTime modified_at;

	@Column(name = "deleted_at")
	@Generated
	private LocalDateTime deleted_at;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Product> products;
}
