package com.example.Studentdemo.model;

public class AttendanceMarkRequest {

 private Long studentId;
 private boolean present;

 public AttendanceMarkRequest() {
 }

 public AttendanceMarkRequest(Long studentId, boolean present) {
     this.studentId = studentId;
     this.present = present;
 }

 public Long getStudentId() {
     return studentId;
 }

 public void setStudentId(Long studentId) {
     this.studentId = studentId;
 }

 public boolean isPresent() {
     return present;
 }

 public void setPresent(boolean present) {
     this.present = present;
 }
}
