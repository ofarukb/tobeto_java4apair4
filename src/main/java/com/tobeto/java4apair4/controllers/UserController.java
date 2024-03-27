package com.tobeto.java4apair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4apair4.entities.User;
import com.tobeto.java4apair4.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@PostMapping
	public String add(@RequestBody User user) {
		userRepository.save(user);
		return "Kullanıcı başarıyla Eklendi.";
	}
	
	@PutMapping
	public String update(@RequestBody User user) {
		userRepository.save(user);
		return "Kullanıcı bilgisi başarıyla güncellendi.";
	}
}
