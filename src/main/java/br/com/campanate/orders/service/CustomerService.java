package br.com.campanate.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanate.orders.entity.Customer;
import br.com.campanate.orders.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer findCustomerById(int id) {
		return customerRepository.findById(id).get();
	}
	
}
