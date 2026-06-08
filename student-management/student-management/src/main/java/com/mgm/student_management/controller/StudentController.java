package com.mgm.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgm.student_management.entity.Student;
import com.mgm.student_management.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {

		return studentService.addStudent(student);
	}

}
