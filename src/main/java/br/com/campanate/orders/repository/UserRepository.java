package br.com.campanate.orders.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.campanate.orders.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}
