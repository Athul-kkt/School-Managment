package com.example.Studentdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Studentdemo.model.Attendance;


public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	   List<Attendance>findByStudentId(Long StudentId);

}
