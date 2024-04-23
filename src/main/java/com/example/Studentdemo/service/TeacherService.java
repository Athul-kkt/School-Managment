package com.example.Studentdemo.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Studentdemo.model.Teacher;
import com.example.Studentdemo.repository.TeacherRepository;


@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
    UserService userService;
	
	
	public ResponseEntity<List<Teacher>> getAllTeachers(){
		try {
            List<Teacher> teacherList = new ArrayList<>();
            teacherRepository.findAll().forEach(teacherList::add);
 
            if (teacherList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
 
            return new ResponseEntity<>(teacherList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }	
	}
	public ResponseEntity<Teacher> addTeacher(Teacher teacher) {
        try {
        	String username = teacher.getFirstName().toLowerCase() + "." + teacher.getLastName().toLowerCase();
            String password = teacher.getFirstName() + "@123";
            String userRole = "Teacher";
            
            userService.addingUser(username,teacher.getEmail(), password, userRole);
            
            Teacher teacherObj = teacherRepository.save(teacher);
            
            
            return new ResponseEntity<>(teacherObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
