package com.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello"); //jsp file name
		
		return modelAndView;
	}

}
