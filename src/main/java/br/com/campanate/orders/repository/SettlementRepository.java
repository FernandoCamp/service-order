package br.com.campanate.orders.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.campanate.orders.entity.Settlement;

public interface SettlementRepository extends CrudRepository<Settlement, Integer> {
	
	public Iterable<Settlement> findByOrderId(int orderId);

}
