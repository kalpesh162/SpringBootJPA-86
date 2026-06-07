package com.app.stud.service;

import java.util.List;

import com.app.stud.model.Student;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(int id, Student student);

    void deleteStudent(int id);
}
