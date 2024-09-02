package com.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/basics")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello(Model model) {
		
		model.addAttribute("message", "Hello Spring MVC Model");
		model.addAttribute("name", "Sai Kiran");
		model.addAttribute("email", "saikiran@gmail.com");
		
		
		return "hello";
	}

}
