package com.mgm.student_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgm.student_management.entity.Student;
import com.mgm.student_management.exception.StudentNotFoundException;
import com.mgm.student_management.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student addStudent(Student student) {

		return studentRepository.save(student);

	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {

		// return studentRepository.findById(id).get();

		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			throw new StudentNotFoundException("Student With " + id + " Not Found");

	}

	@Override
	public Student updateStudent(Integer id, Student updatedstudent) {
		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent()) {
			Student existingStudent = optional.get();
			existingStudent.setAge(updatedstudent.getAge());
			existingStudent.setName(updatedstudent.getName());
			existingStudent.setCourse(updatedstudent.getCourse());
			return studentRepository.save(existingStudent);
		} else {
			throw new StudentNotFoundException("Student not found with ID: " + id);
		}

	}

	@Override
	public void deleteStudent(Integer id) {

		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent())
			studentRepository.deleteById(id);
		else
			throw new StudentNotFoundException("Student With " + id + " Not Found");
	}

}
