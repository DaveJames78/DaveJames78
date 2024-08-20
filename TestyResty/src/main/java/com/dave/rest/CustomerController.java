package com.dave.rest;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dave.model.ESGCustomer;
import com.dave.model.db.ESGCustomerRepository;

/**
 * CustomerController
 * 
 * Version 1.0.0 - Initial version
 * Author - davidj
 */

@RestController
public class CustomerController {

	private final ESGCustomerRepository repository;

	/**
	 * Spring will wire the repository in due to the RestController annotation on this class.
	 */
	public CustomerController(ESGCustomerRepository repository) {
		this.repository = repository;
	}

	
	// Save a new customer to the repository 
	@PostMapping("/customers")
	public ESGCustomer newCustomer(@RequestBody ESGCustomer newCustomer) {
		return repository.save(newCustomer);
	}

	// Return a single customer based on the id.
	@GetMapping("/customers/{id}")
	public Optional<ESGCustomer> getCustomer(@PathVariable String id) {

		return repository.findById(id);
	}

}
