package br.com.campanate.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanate.orders.entity.User;
import br.com.campanate.orders.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
}
