package com.spring.rms.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.rms.entity.ItemOrder;

public interface ItemOrderRepository extends CrudRepository<ItemOrder, Integer> {

}
