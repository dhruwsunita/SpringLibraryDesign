package com.glearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GreatLearning {

	private String CourseName;
	private String CourseType;
	//private String instructorName;
	private FullName instructorName;
	
	public GreatLearning(String courseName) {
		CourseName = courseName;
	}
	public GreatLearning(String courseName, String courseType) {
		CourseName = courseName;
		CourseType = courseType;
	}
	

}
