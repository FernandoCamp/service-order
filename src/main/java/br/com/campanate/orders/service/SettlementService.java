package br.com.campanate.orders.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.campanate.orders.dto.SettlementDto;
import br.com.campanate.orders.entity.Settlement;
import br.com.campanate.orders.repository.SettlementRepository;

@Service
public class SettlementService {

	@Autowired
	private SettlementRepository settlementRepository;
	
	public Iterable<SettlementDto> findSettlementByOrderId(int orderId) {
		List<SettlementDto> settlementDto = new ArrayList<>();
		settlementRepository.findByOrderId(orderId).forEach(settlement -> {
			settlementDto.add(new SettlementDto(settlement));
		});
		return settlementDto;
	}
	
	public Settlement saveSettlement(Settlement settlement) {
		return settlementRepository.save(settlement);
	}
	
}
