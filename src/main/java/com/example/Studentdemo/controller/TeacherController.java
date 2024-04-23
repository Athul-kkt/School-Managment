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

import com.example.Studentdemo.model.Teacher;
import com.example.Studentdemo.service.TeacherService;



@CrossOrigin("*")
@RestController
@RequestMapping("/teacherapi")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	
	@GetMapping("/getallteachers")
    public ResponseEntity<List<Teacher>> getallteachers() {
        return teacherService.getAllTeachers();
    }
    @PostMapping("/addteacher")
    public ResponseEntity<Teacher> addteacher(@RequestBody Teacher teacher) {
       return teacherService.addTeacher(teacher);
    }
 
}
