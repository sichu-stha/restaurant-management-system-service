package com.spring.rms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.rms.entity.OrderPayment;

public interface OrderPaymentRepository extends CrudRepository<OrderPayment, Integer> {
	
	@Query("SELECT ol from OrderPayment ol join User u on u.id = ol.user.id where u.userName = :userName")
	List<OrderPayment> findByUserName(@Param("userName") String userName);

}
