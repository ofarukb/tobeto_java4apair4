package com.tobeto.java4apair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4apair4.entities.Image;
import com.tobeto.java4apair4.repositories.ImageRepository;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	private ImageRepository imageRepository;

	public ImageController(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	@GetMapping
	public List<Image> getAll(){
		return imageRepository.findAll();
	}
	
	@PostMapping
	public String add(@RequestBody Image image) {
		imageRepository.save(image);
		return "Resim başarıyla eklendi";
	}
}
