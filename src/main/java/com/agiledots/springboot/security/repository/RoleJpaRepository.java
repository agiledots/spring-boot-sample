package com.agiledots.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agiledots.springboot.security.entity.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Integer> {

	
}
