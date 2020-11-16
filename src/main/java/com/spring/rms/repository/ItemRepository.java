package com.spring.rms.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.rms.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
