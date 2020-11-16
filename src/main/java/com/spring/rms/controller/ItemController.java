package com.spring.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rms.entity.Item;
import com.spring.rms.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping("/getAllItems")
	private ResponseEntity<List<Item>> getAllItems() {
		return ResponseEntity.ok(itemService.getAllItems());
	}
}
