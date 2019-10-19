package br.com.campanate.orders.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanate.orders.dto.OrderDto;
import br.com.campanate.orders.dto.UserDto;
import br.com.campanate.orders.entity.User;
import br.com.campanate.orders.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public Iterable<UserDto> findAllUsers() {
		ArrayList<UserDto> users = new ArrayList<>();
		userRepository.findAll().forEach(user -> {
			Map<Integer, OrderDto> orderDto = new HashMap<>();
			user.getOrder().forEach((orderId, order) -> {
				orderDto.put(orderId, new OrderDto(order));
			});
			users.add(new UserDto(user.getLogin(), user.getPassword(), orderDto));
		});
		return users;
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
}
