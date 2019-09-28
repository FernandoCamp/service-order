package br.com.campanate.orders.dto;

import java.time.LocalDateTime;

import br.com.campanate.orders.entity.Settlement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettlementDto {

	private String userLogin;
	private String settlement;
	private LocalDateTime createdAt;
	
	public SettlementDto(Settlement settlement) {
		this.userLogin = settlement.getUser().getLogin();
		this.settlement = settlement.getSettlement();
		this.createdAt = settlement.getCreatedAt(); 
	}
	
}
