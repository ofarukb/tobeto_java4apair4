package com.tobeto.java4aPair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4aPair4.entities.Address;
import com.tobeto.java4aPair4.repositories.AddressRepository;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
	private AddressRepository addressRepository;

	public AddressController(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}

	@GetMapping
	public List<Address> getAll() {
		return addressRepository.findAll();
	}

	@PostMapping
	public String add(@RequestBody Address address) {
		addressRepository.save(address);
		return "Adres başarıyla Eklendi.";
	}
}
