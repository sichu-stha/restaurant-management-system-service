package com.spring.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rms.entity.Item;
import com.spring.rms.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired 
	ItemRepository itemRepository;
	
	public List<Item> getAllItems(){
		return (List<Item>) itemRepository.findAll();
	}
}
