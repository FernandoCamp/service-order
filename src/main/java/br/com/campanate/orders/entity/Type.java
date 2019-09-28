package br.com.campanate.orders.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "types")
@Getter
@Setter
public class Type {

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private boolean active;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	private List<Order> order;
	
}
