package br.com.campanate.orders.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "orders")
@Getter
@Setter
public class Order {

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(insertable = false, updatable = false)
	private LocalDateTime opened;
	@Column(insertable = false)
	private LocalDateTime closed;
	@Column(updatable = false)
	private String problemDescription;
	private boolean prioritary;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", updatable = false)
	private User user;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "statusId")
	private Status status;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "typeId", updatable = false)
	private Type type;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customerId", updatable = false)
	private Customer customer;
	
}
