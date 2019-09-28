package br.com.campanate.orders.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.campanate.orders.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
