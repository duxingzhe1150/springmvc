package test.springmvc.controller;

import test.test.Person;

public class Student extends Person{
	
	private String schoolName;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
}
