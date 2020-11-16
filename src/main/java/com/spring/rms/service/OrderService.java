package com.spring.rms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rms.entity.ItemOrder;
import com.spring.rms.entity.OrderPayment;
import com.spring.rms.repository.ItemOrderRepository;
import com.spring.rms.repository.OrderPaymentRepository;
import com.spring.rms.utils.UserUtils;

@Service
public class OrderService {

	@Autowired
	private OrderPaymentRepository orderPayment;
	
	@Autowired
	private ItemOrderRepository itemOrderRepository;

	public List<OrderPayment> getAllOrders() {
		return (List<OrderPayment>) orderPayment.findByUserName(UserUtils.getUserName());
	}

	public OrderPayment getOrderById(Integer id) {
		return orderPayment.findById(id).get();
	}

	public void createOrder(OrderPayment order) {
		orderPayment.save(order);
	}
	
	public List<ItemOrder> getAllOrderItems() {
		return (List<ItemOrder>) itemOrderRepository.findAll();
	}
	
	public Map<String, Integer> getTotalOrderedQuantityByItem() {
		List <ItemOrder> allOrderList = getAllOrderItems();
		if(allOrderList.isEmpty())
			return null;
		Map<String, Integer> orderMap = new HashMap<>();
		for(ItemOrder item: allOrderList) {
			String itemName = item.getItem().getItemName();
			Integer quantity = item.getQuantity();
			orderMap.putIfAbsent(itemName, quantity);
			orderMap.computeIfPresent(itemName, (k,v)-> v + quantity);
		}
		return orderMap;
	}
}
