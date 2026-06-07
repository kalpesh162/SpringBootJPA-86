package com.app.stud.repos;

import java.util.List;

import com.app.stud.model.Student;

public interface StudentDao {
	
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(int id, Student student);

    void deleteStudent(int id);

}
