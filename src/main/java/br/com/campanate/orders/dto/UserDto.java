package br.com.campanate.orders.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
	
	private String login;
	private String password;
	private Map<Integer, OrderDto> orders;
	
}
