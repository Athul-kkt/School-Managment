package com.example.Studentdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Studentdemo.model.Student;
import com.example.Studentdemo.service.StudentService;
 

@CrossOrigin("*")
@RestController
@RequestMapping("/studentapi")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/getallstudents")
    public ResponseEntity<List<Student>> getallstudents() {
        return studentService.getAllStudents();
    }
    @PostMapping("/addstudent")
    public ResponseEntity<Student> addstudent(@RequestBody Student student) {
       return studentService.addStudent(student);
    }
 
 
}