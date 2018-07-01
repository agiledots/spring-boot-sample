package com.agiledots.springboot.openstreetmap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/map")
public class MapController {

	@RequestMapping("/index")
	public String index() {

		return "map/index";
	}

	@RequestMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView("/map/detail");
		modelAndView.addObject("id", id);
		return modelAndView;
	}
}
