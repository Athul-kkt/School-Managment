package com.example.Studentdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Studentdemo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
	 
}