package com.tobeto.java4apair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4apair4.entities.Country;
import com.tobeto.java4apair4.repositories.CountryRepository;

@RestController
@RequestMapping("/api/countries")
public class CountryController {
	private CountryRepository countryRepository;

	public CountryController(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}

	@GetMapping
	public List<Country> getAll() {
		return countryRepository.findAll();
	}

	public String add(@RequestBody Country country) {
		countryRepository.save(country);
		return "Ülke başarıyla eklendi";
	}
}
