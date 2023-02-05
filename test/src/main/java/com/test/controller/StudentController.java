package com.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.models.Student;
import com.test.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
// create student
@PostMapping("/stu")
private Student createStudent(@RequestBody Student student) {
	
return studentService.createStudent(student);
}

// update student
@PutMapping("/stu/{id}")
private Student updateStudent(@PathVariable ( value = "id") Long id  ,@RequestBody Student student) {
	
	
	return studentService.updateStudent(id, student);
	
		
}
//delete student 
@DeleteMapping("/stu/{id}")
private void deleteStudent(@PathVariable Long id) {
	studentService.deleteStudentById(id);
}
//get student 
@GetMapping("/stu/{id}")
private Student getStudentById(@PathVariable Long id) {
	return studentService.getStudentById(id);
}
@GetMapping("/stu")
private List<Student> getAllStudent() {
	return studentService.getAllStudents();
}










}