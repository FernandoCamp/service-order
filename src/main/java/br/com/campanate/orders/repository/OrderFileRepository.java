package br.com.campanate.orders.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.campanate.orders.entity.OrderFile;

public interface OrderFileRepository extends CrudRepository<OrderFile, Integer> {

	public Iterable<OrderFile> findByOrderId(int orderId);
	
}
