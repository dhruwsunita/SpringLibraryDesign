package com.glearning.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.glearning.library.model.FullName;
import com.glearning.library.model.GreatLearning;
import com.glearning.library.service.ExampleService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

	public GreatLearning get() {
        log.info("Inside get() method");
		GreatLearning glearning = new GreatLearning();
		glearning.setCourseName("Learn Controller in Spring Boot");
		glearning.setCourseType("Information Technology");
//		glearning.setInstructorName("Samarth Narula");
		return glearning;

	}

	public GreatLearning customInfo(String courseName, String courseType,  String firstName, String lastName) {
		log.info("Inside customInfo() method ");
		GreatLearning glearning = new GreatLearning();
		glearning.setCourseName(courseName);
		glearning.setCourseType(courseType);
		glearning.setInstructorName(FullName.builder().firstName("Samarth").lastName("Narula").build());
		// glearning.setInstructorName(instructorName);
		return glearning;

	}

}
