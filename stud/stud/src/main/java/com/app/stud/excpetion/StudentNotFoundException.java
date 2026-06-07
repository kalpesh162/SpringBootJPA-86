package com.app.stud.excpetion;

public class StudentNotFoundException extends RuntimeException {

	public StudentNotFoundException() {

	}

	public StudentNotFoundException(String message) {
		super(message);
	}
	
}
