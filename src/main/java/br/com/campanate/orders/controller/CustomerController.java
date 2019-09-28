package br.com.campanate.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanate.orders.entity.Customer;
import br.com.campanate.orders.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@CrossOrigin
	@GetMapping("/customers/{id}")
	public Customer findCustomerById(@PathVariable int id) {
		return customerService.findCustomerById(id);
	}
	
}
