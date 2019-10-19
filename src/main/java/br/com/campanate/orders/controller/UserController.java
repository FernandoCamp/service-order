package br.com.campanate.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanate.orders.dto.UserDto;
import br.com.campanate.orders.entity.User;
import br.com.campanate.orders.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Iterable<UserDto> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
}
