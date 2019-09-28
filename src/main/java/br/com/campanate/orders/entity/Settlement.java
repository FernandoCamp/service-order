package br.com.campanate.orders.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "settlements")
@Getter
@Setter
public class Settlement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private int id;
	@Column(updatable = false)
	private String settlement;
	@ColumnDefault("NOW()")
	@Column(insertable = false, updatable = false)
	private LocalDateTime createdAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", updatable = false)
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId", updatable = false)
	private Order order;
	
}
