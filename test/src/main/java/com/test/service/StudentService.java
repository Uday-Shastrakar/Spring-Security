package com.test.service;

import java.util.List;

import com.test.models.Student;

public interface StudentService {

//get all student 	
List<Student> getAllStudents();

//get student by id 
 Student getStudentById(Long id);
 
 //create Student
 Student createStudent(Student student);
 
 //delete student by id
 void deleteStudentById(Long id);
 
 //update student 
 
 Student updateStudent(Long id, Student student);




}
