package com.glearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.library.model.GreatLearning;
import com.glearning.library.service.ExampleService;


//@Controller
@RestController
public class ControllerExample {
	
	@Autowired
	ExampleService exampleService;
	@GetMapping("/info")
	//@ResponseBody
	public GreatLearning get() {       // API method
		
		GreatLearning glearning = new GreatLearning();
		return exampleService.get();
		
	}
	
	//API method
	@PostMapping("customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		return exampleService.customInfo(courseName, courseType, firstName, lastName);

		
	}

}
