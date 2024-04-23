package com.example.Studentdemo.controller;

 
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Studentdemo.model.Attendance;
import com.example.Studentdemo.model.AttendanceMarkRequest;
import com.example.Studentdemo.service.AttendanceService;

 
@CrossOrigin("*")
@RestController
@RequestMapping("/attendanceapi")
public class AttendanceController {
 
 
	   @Autowired
	   private AttendanceService attendanceService;
	   
	   @PostMapping("/markAttendance")
	    public String markAttendance(@RequestBody AttendanceMarkRequest attendanceMarkRequest) {
	        attendanceService.markAttendance(attendanceMarkRequest.getStudentId(), LocalDate.now(), attendanceMarkRequest.isPresent());
	        return "redirect:/";
	    }
	    
	    @GetMapping("/attendance/{studentId}")
	    public double getAttendance(@PathVariable String studentId) {
	    	
	    	 Long parsedStudentId ;
	    	 parsedStudentId = Long.parseLong(studentId);	    	 
	         double attendancePercentage = attendanceService.calculateAttendancePercentage(parsedStudentId);
	         
	         return attendancePercentage;
	         
//	        List<Attendance> attendanceList = attendanceService.getStudentAttendance(studentId);
//	        double attendancePercentage = attendanceService.calculateAttendancePercentage(attendanceList);
////	        model.addAttribute("attendanceList", attendanceList);
////	        model.addAttribute("attendancePercentage", attendancePercentage);
//	        return "attendance";
	    }
	   
	   
//	   @PostMapping("/mark")
//	   public ResponseEntity<Attendance> markAttendance(@RequestParam Attendance  attendance) {
//		   return attendanceService.markAttendance(attendance);
// 
//	   }
	   // Add other 
	}