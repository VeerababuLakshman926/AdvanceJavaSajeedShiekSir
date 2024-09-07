	package com.dl.controller;
	
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
	
	@Controller
	public class HomeController {
		
		//http://localhost:8080/15SpringMVC_ModelandView/hello/101/raju/kumar/4545/hyderabad
		@RequestMapping(value = "/hello/{id}/{firstName}/{lastName}/{contact}/{location}", method = RequestMethod.GET)
		public ModelAndView hello(
				@PathVariable("id") String id,
				@PathVariable("firstName") String firstName,
				@PathVariable("lastName") String lastName,
				@PathVariable("contact") String contact,
				@PathVariable("location") String location) {
			
			ModelAndView modelAndView = new ModelAndView();
			
			modelAndView.setViewName("hello"); //jsp file name
			
			return modelAndView;
		}
	
	}
