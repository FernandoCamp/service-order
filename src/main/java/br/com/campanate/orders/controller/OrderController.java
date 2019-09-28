package br.com.campanate.orders.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.campanate.orders.dto.OrderDto;
import br.com.campanate.orders.entity.Order;
import br.com.campanate.orders.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@CrossOrigin
	@PostMapping("/orders")
	public ResponseEntity<Order> saveOrder(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) throws IllegalStateException, IOException {
		System.out.println(file.getOriginalFilename());
		File fileTransfer = new File("/home/fernando", file.getOriginalFilename());
		file.transferTo(fileTransfer);
//		model.addAttribute("file", storage)
//		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
		return null;
	}
//	
//	@CrossOrigin
//	@PostMapping("/orders")
//	public ResponseEntity<Order> saveOrder(@RequestBody Order order, @RequestParam CommonsMultipartFile file) {
//		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
//	}
	
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
