package com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
