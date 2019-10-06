package br.com.campanate.orders.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.campanate.orders.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

	private int id;
	private String customerName;
	private String userLogin;
	private String status;
	private String type;
	private LocalDateTime opened;
	private LocalDateTime closed;
	private String problemDescription;
	private boolean prioritary;
	private List<String> orderFiles;
	
	public OrderDto (Order order) {
		this.id = order.getId();
		this.customerName = order.getCustomer().getName();
		this.userLogin = order.getUser().getLogin();
		this.status = order.getStatus().getDescription();
		this.type = order.getType().getDescription();
		this.opened = order.getOpened();
		this.closed = order.getClosed();
		this.problemDescription = order.getProblemDescription();
		this.prioritary = order.isPrioritary();
		this.orderFiles = order.orderFilesAddress();
	}
	
}
