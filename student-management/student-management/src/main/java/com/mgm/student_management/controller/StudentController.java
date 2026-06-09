package com.mgm.student_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// @RequestMapping(value = "/add",method = RequestMethod.POST)
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {

		return studentService.addStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {

		Student student = studentService.getStudentById(id);
		if (student != null) {
			studentService.deleteStudent(id);
			return "Student With id " + id + "   DELETED ";
		} else
			return "Student With id " + id + "  NOT FOUND ";
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		if (student != null)
			return student;

		return null;
	}

}
