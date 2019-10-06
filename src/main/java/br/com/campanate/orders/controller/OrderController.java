package br.com.campanate.orders.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.campanate.orders.dto.OrderDto;
import br.com.campanate.orders.entity.Order;
import br.com.campanate.orders.entity.OrderFile;
import br.com.campanate.orders.repository.OrderFileRepository;
import br.com.campanate.orders.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderFileRepository orderFileRepository;

	@CrossOrigin(origins = "*")
	@PostMapping("/orders/file")
	public ResponseEntity<?> sendFile(@RequestParam("files") MultipartFile files[], String order) throws IllegalStateException, IOException {
		final String caminho = "/home/fernando/Documentos/service-order/images/";
		
		Order orderMapped = new ObjectMapper().readValue(order, Order.class);
		Order savedOrder = orderService.saveOrder(orderMapped);
		
		short quantidade = 1;
		
		ArrayList<OrderFile> orderFiles = new ArrayList<>();
		
		for (MultipartFile file : files) {
			String nomeImagem = "orderid" + savedOrder.getId() + "-nth" + quantidade + ".png";
			File fileTransfer = new File(caminho, nomeImagem);
			file.transferTo(fileTransfer);
			quantidade ++;
			orderFiles.add(new OrderFile(savedOrder, nomeImagem));
		}
		
		orderFileRepository.saveAll(orderFiles);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@PostMapping("/orders")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<OrderDto> findOrderById(@PathVariable int orderId) {
		OrderDto orderDto = orderService.findOrderById(orderId);
		if (orderDto != null) {
			return new ResponseEntity<OrderDto>(orderDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin
	@GetMapping("/orders/customerId/{customerId}")
	public ResponseEntity<List<OrderDto>> findOrderByCustomerId(@PathVariable int customerId) {
		List<OrderDto> orderDto = (List<OrderDto>) orderService.findOrderByCustomerId(customerId);
		if (orderDto.size() > 0) {
			return new ResponseEntity<List<OrderDto>>(orderDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
