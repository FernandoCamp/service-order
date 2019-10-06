package br.com.campanate.orders.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "order_files")
public class OrderFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "orderId", updatable = false)
	@JsonIgnore
	private Order order;
	private String address;
	
	public OrderFile(Order order, String address) {
		this.order = order;
		this.address = address;
	}
	
}
