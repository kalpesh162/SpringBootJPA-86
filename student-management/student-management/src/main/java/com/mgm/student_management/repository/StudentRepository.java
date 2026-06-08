package com.mgm.student_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgm.student_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
