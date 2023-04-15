package com.glearning.library.service;

import com.glearning.library.model.GreatLearning;

public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName);

}