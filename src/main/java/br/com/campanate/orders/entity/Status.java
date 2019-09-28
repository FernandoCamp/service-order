package br.com.campanate.orders.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Status {

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(updatable = false)
	private String description;
	@Column(updatable = false)
	private boolean active;
	@Column(insertable = false, updatable = false)
	@OneToMany(mappedBy = "status")
	private List<Order> order;
	
}
