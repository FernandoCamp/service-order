package br.com.campanate.orders.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.campanate.orders.entity.Order;

@RestController
public class DataSourceTestController {

	@GetMapping("/teste")
	public ArrayList<Order> createDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("fernando");
		dataSource.setPassword("26021997");
		dataSource.setUrl("jdbc:mysql://localhost:3306/orders");
		Connection connection = dataSource.getConnection();
		PreparedStatement queryPreparada = connection.prepareStatement("SELECT * FROM orders");
		ResultSet resultado = queryPreparada.executeQuery();
		ArrayList<Order> orders = new ArrayList<>();
		while(resultado.next()) {
			Order order = new Order();
			order.setId(resultado.getInt("id"));
			order.setProblemDescription(resultado.getString("problem_description"));
			order.setOpened(resultado.getTimestamp("opened").toLocalDateTime());
			orders.add(order);
		}
		resultado.close();
		connection.close();
		
		return orders;
	}
	
}
