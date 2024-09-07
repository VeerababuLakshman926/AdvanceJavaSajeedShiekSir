	package com.dl.controller;
	
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
	
	@Controller
	public class HomeController {
		
		//http://localhost:8080/15SpringMVC_ModelandView/hello?id=101&firstName=raju&lastName=kumar&contact=934934&location=hyderabad
		@RequestMapping(value = "/hello", method = RequestMethod.GET)
		public ModelAndView hello(
				@RequestParam(name="id") int id,
				@RequestParam(name="firstName") String firstName,
				@RequestParam(name="lastName") String lastName,
				@RequestParam(name="contact") String contact,
				@RequestParam(name="location") String location) {
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("id", id);
			modelAndView.addObject("firstName", firstName);
			modelAndView.addObject("lastName", lastName);
			modelAndView.addObject("contact", contact);
			modelAndView.addObject("location", location);
			
			modelAndView.setViewName("hello"); //jsp file name
			
			return modelAndView;
		}
	
	}
