package com.app.stud.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.stud.excpetion.StudentNotFoundException;
import com.app.stud.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	private List<Student> students = new ArrayList<>();
	private int studentIdCounter = 1;
	@Override
	public Student saveStudent(Student student) {
		student.setId(studentIdCounter++);
		students.add(student);
		return student;
	}
	@Override
	public List<Student> getAllStudents() {
		return students;
	}
	@Override
	public Student getStudentById(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				return students.get(i);
			}
		}
		throw new StudentNotFoundException("Student not found with ID : " + id);
	}

	@Override  
	public Student updateStudent(int id, Student updatedStudent) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				Student student=students.get(i);
				student.setName(updatedStudent.getName());
				student.setAge(updatedStudent.getAge());
				student.setCourse(updatedStudent.getCourse());
				return student;
			}
		}

		throw new StudentNotFoundException("Student with id Not found :  "+id);
	}

	@Override
	public void deleteStudent(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				Student student=students.get(i);
				students.remove(student);
				return;
			}
		}
		throw new StudentNotFoundException("Student with id Not found :  "+id);
	}

}
