package com.agiledots.springboot.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.util.StringUtils;

import com.agiledots.springboot.security.entity.User;
import com.agiledots.springboot.security.entity.UserRole;
import com.agiledots.springboot.security.repository.RoleJpaRepository;
import com.agiledots.springboot.security.repository.UserJpaRepository;
import com.agiledots.springboot.security.repository.UserRoleJpaRepository;

public class DemoUserDetailService implements UserDetailsService {

	@Autowired
	RoleJpaRepository roleDao;

	@Autowired
	UserRoleJpaRepository userRoleDao;

	@Autowired
	UserJpaRepository userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO

		User user = userDao.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + " not found");
		}

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		List<UserRole> userRoles = userRoleDao.listByUserId(user.getId());

		for (UserRole userRole : userRoles) {
			Integer roleId = userRole.getRoleId();
			String roleName = roleDao.findById(roleId).get().getRole();

			if (!StringUtils.isEmpty(roleName)) {
				authorities.add(new SimpleGrantedAuthority(roleName));
			}

			System.err.println("username is " + username + ", " + roleName);
		}

		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}
	
}
