package br.com.campanate.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanate.orders.dto.SettlementDto;
import br.com.campanate.orders.entity.Settlement;
import br.com.campanate.orders.service.SettlementService;

@RestController
public class SettlementController {

	@Autowired
	private SettlementService settlementService;
	
	@CrossOrigin
	@GetMapping("/settlements/orderId/{orderId}")
	public Iterable<SettlementDto> findSettlementByOrderId(@PathVariable int orderId) {
		return settlementService.findSettlementByOrderId(orderId);
	}
	
	@CrossOrigin
	@PostMapping("/settlements")
	public ResponseEntity<Settlement> saveSettlement(@RequestBody Settlement settlement) {
		return new ResponseEntity<Settlement>(settlementService.saveSettlement(settlement), HttpStatus.CREATED);
	}
	
}
