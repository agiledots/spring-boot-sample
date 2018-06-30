package com.agiledots.springboot.security.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agiledots.springboot.security.entity.Role;
import com.agiledots.springboot.security.entity.User;
import com.agiledots.springboot.security.entity.UserRole;
import com.agiledots.springboot.security.repository.RoleJpaRepository;
import com.agiledots.springboot.security.repository.UserJpaRepository;
import com.agiledots.springboot.security.repository.UserRoleJpaRepository;

@Service
public class InitData {

	@Autowired
	RoleJpaRepository roleDao;

	@Autowired
	UserJpaRepository userDao;

	@Autowired
	UserRoleJpaRepository userRoleDao;

	public void init() {
		String uuid = UUID.randomUUID().toString();

		// User
		User admin = new User();
		User user = new User();
		admin.setUsername("admin_" + uuid);
		admin.setPassword("admin");
		user.setUsername("user_" + uuid);
		user.setPassword("user");

		userDao.save(admin);
		userDao.save(user);

		// Role
		Role adminRole = new Role();
		Role userRole = new Role();
		adminRole.setRole("ROLE_ADMIN");
		userRole.setRole("ROLE_USER");

		roleDao.save(adminRole);
		roleDao.save(userRole);

		// UserRole
		UserRole adminUserRole = new UserRole();
		adminUserRole.setUserId(admin.getId());
		adminUserRole.setRoleId(adminRole.getId());

		UserRole userUserRole = new UserRole();
		userUserRole.setUserId(user.getId());
		userUserRole.setRoleId(userRole.getId());

		userRoleDao.save(adminUserRole);
		userRoleDao.save(userUserRole);
	}

	public static void main(String[] args) {
		InitData object = new InitData();
		object.init();
	}
}
