package com.app.stud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.stud.model.Student;
import com.app.stud.service.StudentService;

@RestController
@RequestMapping("\students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {

		return studentService.addStudent(student);
	}

	@GetMapping("/all")
	public List<Student> getAllStudents() {

		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {

		return studentService.getStudentById(id);
	}

	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {

		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {

		studentService.deleteStudent(id);

		return "Student with ID " + id + " deleted successfully";
	}

}
