package com.agiledots.springboot.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

	@PreAuthorize(value = "hasRole('ADMIN')")
	@RequestMapping(value = "/admin")
	@ResponseBody
	public String admin() {
		return "this is a admin page.";
	}

	@PreAuthorize(value = "hasRole('USER')")
	@RequestMapping(value = "/user")
	@ResponseBody
	public String user() {
		return "this is a user page.";
	}

}
