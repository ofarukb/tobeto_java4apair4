package com.tobeto.java4aPair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4aPair4.entities.City;
import com.tobeto.java4aPair4.repositories.CityRepository;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	private CityRepository cityRepository;

	public CityController(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}
	
	@GetMapping
	public List<City> getAll(){
		return cityRepository.findAll();
	}
	
	@PostMapping
	public String add(@RequestBody City city) {
		cityRepository.save(city);
		return "Şehir başarıyla eklendi";
	}
}
