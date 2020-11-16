package com.spring.rms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rms.entity.ItemOrder;
import com.spring.rms.entity.OrderPaymentDTO;
import com.spring.rms.entity.OrderDTO;
import com.spring.rms.entity.OrderPayment;
import com.spring.rms.repository.ItemRepository;
import com.spring.rms.repository.UserRepository;
import com.spring.rms.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ItemRepository itemRepo;

	@RequestMapping("/saveOrder")
	public ResponseEntity<?> saveOrder(@RequestBody OrderPaymentDTO orderPaymentDTO) {
		OrderPayment orderPayment = (new OrderPayment(userRepo.findById(orderPaymentDTO.getUser().getId()).get()
				,orderPaymentDTO.getBillAmount()
				,new java.sql.Date(new Date().getTime())));

		List<ItemOrder> orderList = new ArrayList<>();
		for (OrderDTO order : orderPaymentDTO.getItems()) {
			ItemOrder o = new ItemOrder(order.getQuantity(), order.getTotalPrice());
			o.setItem(itemRepo.findById(order.getItem().getId()).get());
			orderList.add(o);
		}
		orderPayment.setItemOrder(orderList);		
		orderService.createOrder(orderPayment);
		return ResponseEntity.ok(orderPayment);
	}

	@RequestMapping("getOrders")
	public ResponseEntity<?> getOrders() {
		return ResponseEntity.ok().body(orderService.getAllOrders());
	}
	
	@RequestMapping("getOrderById")
	public ResponseEntity<?> getOrderById(@RequestParam("id") Integer id) {
		return ResponseEntity.ok(orderService.getOrderById(id));
	}
	
	@RequestMapping("getTotalOrderedQuantityByItem")
	public ResponseEntity<?> getTotalOrderedQuantityByItem() {
		return ResponseEntity.ok(orderService.getTotalOrderedQuantityByItem());
	}

}
