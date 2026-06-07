package com.example.helloapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloapp.model.Student;

//@Controller  --- View or ModelAndView

//Rest Web Sevices   Rest API  || Restful API

@RestController
public class HelloRestController {

	// @RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome To Spring Boot";
	}

	@GetMapping("/visit")
	public Student getStudent() {
		Student student = new Student(11, "Kareena", 77.88);
		return student;

	}

	@GetMapping("/all")
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		Student student = new Student(11, "Ramesh", 66.66);
		Student student1 = new Student(12, "Suresh", 76.66);
		Student student2 = new Student(13, "Rajesh", 65.66);
		Student student3 = new Student(14, "Ganesh", 61.66);
		Student student4 = new Student(15, "Kalpesh", 16.66);
		list.add(student4);
		list.add(student3);
		list.add(student2);
		list.add(student1);
		list.add(student);
		return list;

	}

}
