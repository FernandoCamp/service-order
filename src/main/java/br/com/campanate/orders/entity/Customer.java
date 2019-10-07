package br.com.campanate.orders.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "customers")
@Getter
@Setter
public class Customer {

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ColumnDefault("NOW()")
	@Column(insertable = false, updatable = false)
	private LocalDateTime registeredAt;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Order> orders;
	
}
