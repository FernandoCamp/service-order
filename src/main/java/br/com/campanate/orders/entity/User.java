package br.com.campanate.orders.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class User {

	@Id
	@Column(insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@MapKeyColumn(name = "id")
	private Map<Integer, Order> order;
	
}
