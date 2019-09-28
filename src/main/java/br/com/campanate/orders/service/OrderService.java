package br.com.campanate.orders.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanate.orders.dto.OrderDto;
import br.com.campanate.orders.entity.Order;
import br.com.campanate.orders.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Iterable<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	public Iterable<Order> saveAllOrders(Iterable<Order> orders) {
		return orderRepository.saveAll(orders);
	}

	public OrderDto findOrderById(int orderId) {
		Order order = orderRepository.findById(orderId).get();
		if (order != null) {
			return new OrderDto(order);
		}

		return null;
	}
	
	public Order saveOrder(Order order) {
		System.out.println(order.getStatus().getId());
		if (order.getStatus() != null) {
			order.setClosed(order.getStatus().getId() == 2 ? LocalDateTime.now() : null);
		}
		return orderRepository.save(order);
	}
	
	public Iterable<OrderDto> findOrderByCustomerId(int customerId) {
		List<OrderDto> ordersDto = new ArrayList<>(); 
		orderRepository.findByCustomerIdOrderByIdDesc(customerId).forEach(order -> {
			ordersDto.add(new OrderDto(order));
		});
		return ordersDto; 
	}

}
