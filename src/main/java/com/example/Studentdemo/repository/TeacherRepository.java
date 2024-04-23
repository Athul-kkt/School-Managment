package com.example.Studentdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Studentdemo.model.Teacher;

 
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
 
}