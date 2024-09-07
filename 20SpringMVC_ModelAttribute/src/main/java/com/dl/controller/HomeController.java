package com.dl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dl.model.Student;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String student(ModelAndView modelAndView) {
		
		return "index";
	}


	@RequestMapping(value = "/studentValues", method = RequestMethod.POST)
	public ModelAndView studentValues(
			@RequestParam(name = "id") int id, 
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName, 
			@RequestParam(name = "contact") String contact,
			@RequestParam(name = "location") String location) {
		
		Student student = new Student(id, firstName, lastName, contact, location);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", student);
		modelAndView.setViewName("studentValues"); // jsp file name

		return modelAndView;
	}
	
//	@RequestMapping(value = "/studentValues", method = RequestMethod.POST)
//	public ModelAndView studentValues(@ModelAttribute Student student) {
//		
//		
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("student", student);
//		modelAndView.setViewName("studentValues"); // jsp file name
//
//		return modelAndView;
//	}

}
