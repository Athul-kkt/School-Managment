package com.example.Studentdemo.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
import com.example.Studentdemo.model.Student;
import com.example.Studentdemo.repository.StudentRepository;

 
@Service
public class StudentService {
	@Autowired
	 private StudentRepository studentRepository;
	
	@Autowired
    UserService userService;

//	public List<Student>getAllStudents(){
//		return studentRepository.findAll();
//	}
	public Student getStudentById(Long studentId) {
	       return studentRepository.findById(studentId)
	                               .orElse(null);
	   }

	public ResponseEntity<List<Student>> getAllStudents(){
		try {
            List<Student> studentList = new ArrayList<>();
            studentRepository.findAll().forEach(studentList::add);
 
            if (studentList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
 
            return new ResponseEntity<>(studentList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }	
	}
	public ResponseEntity<Student> addStudent(Student student) {
        try {
        	
        	String username = student.getFirstName().toLowerCase() + "." + student.getLastName().toLowerCase();
            String password = student.getFirstName() + "@123";
            String userRole = "Student";
            
            userService.addingUser(username,student.getEmail(), password, userRole);
            
            
            Student studentObj = studentRepository.save(student);
            
            
            
            
            return new ResponseEntity<>(studentObj, HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
}