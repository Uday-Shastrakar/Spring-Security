package com.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.models.Student;
import com.test.repositories.StudentRepository;
import com.test.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	StudentRepository studentRepository;
	
	

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student) ;
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		
		Student stu = studentRepository.findById(id).get();
		stu.setFirstName(student.getFirstName());
		stu.setLastName(student.getLastName());
		return studentRepository.save(stu);
	}

}
