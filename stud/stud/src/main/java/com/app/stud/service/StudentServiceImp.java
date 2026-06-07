package com.app.stud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.stud.model.Student;
import com.app.stud.repos.StudentDao;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Student addStudent(Student student) {

		return studentDao.saveStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {

		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) {

		return studentDao.getStudentById(id);
	}

	@Override
	public Student updateStudent(int id, Student student) {

		return studentDao.updateStudent(id, student);
	}

	@Override
	public void deleteStudent(int id) {

		studentDao.deleteStudent(id);
	}

}
