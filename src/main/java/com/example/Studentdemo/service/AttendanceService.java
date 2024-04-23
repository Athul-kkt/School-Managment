package com.example.Studentdemo.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Studentdemo.model.Attendance;
import com.example.Studentdemo.model.Student;
import com.example.Studentdemo.repository.AttendanceRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
 
@Service
public class AttendanceService {

 
   @Autowired
   private AttendanceRepository attendanceRepository;
   
   @Autowired
   StudentService studentService;
   
   public void markAttendance(Long studentId, LocalDate date, boolean present) {
	   try {
		   Student studentObj = studentService.getStudentById(studentId);
		   
	       Attendance attendance = new Attendance();
	       attendance.setStudent(studentObj);
	       attendance.setDate(date);
	       attendance.setPresent(present);
	       attendanceRepository.save(attendance);
	   }catch (Exception e) {
         new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     }
   }
   
   public List<Attendance> getStudentAttendance(Long studentId) {
       return attendanceRepository.findByStudentId(studentId);
   }
   
   public double calculateAttendancePercentage(Long studentId) {
	   
	   List<Attendance> attendanceList =attendanceRepository.findByStudentId(studentId);
	   
       long totalClasses = attendanceList.size();
       long presentClasses = attendanceList.stream().filter(Attendance::isPresent).count();
       return (double) presentClasses / totalClasses * 100;
   }
 
//   public ResponseEntity<Attendance> markAttendance(Attendance attendance) {
//       try {
//	       Attendance attendanceObj=attendanceRepository.save(attendance);
//	       return new ResponseEntity<>(attendanceObj, HttpStatus.CREATED);
//       }catch (Exception e) {
//           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//       }
//   }
}
//@Service
//public class AttendanceService {
//    @Autowired
//    private AttendanceRepository attendanceRepository;
//
//    public void markAttendance(User student, LocalDate date, boolean present) {
//        Attendance attendance = new Attendance();
//        attendance.setUser(student);
//        attendance.setDate(date);
//        attendance.setPresent(present);
//        attendanceRepository.save(attendance);
//    }
//
//}