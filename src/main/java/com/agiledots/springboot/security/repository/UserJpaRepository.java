package com.agiledots.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agiledots.springboot.security.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

	@Query(value="select * from user where username = :username", nativeQuery = true)
	User getUserByUsername(@Param("username") String username);

	@Query(value = "select count(*) from user;", nativeQuery = true)
	Integer getUserCount();

}
