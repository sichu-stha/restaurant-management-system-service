package com.spring.rms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.rms.entity.User;


public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "select * from user where user_name=:userName", nativeQuery = true)
	User getUserFromUsername(@Param("userName") String userName);
}
