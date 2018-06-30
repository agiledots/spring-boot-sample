package com.agiledots.springboot.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agiledots.springboot.security.entity.Role;
import com.agiledots.springboot.security.entity.UserRole;

public interface UserRoleJpaRepository extends JpaRepository<UserRole, Integer> {
	@Query(value="select * from user_role where user_id = :userid", nativeQuery = true)
	List<UserRole> listByUserId(@Param("userid") Integer userid);
}
