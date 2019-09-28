package br.com.campanate.orders.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.campanate.orders.entity.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {

	public Iterable<Order> findByCustomerIdOrderByIdDesc(int customerId);
	
}
