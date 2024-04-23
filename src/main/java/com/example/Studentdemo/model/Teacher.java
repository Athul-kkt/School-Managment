package com.example.Studentdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Entity
@Table(name="teacher_table")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
 
public class Teacher {
 
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@Column
		private String firstName;
		@Column
		private String lastName;
		@Column
		private String email;
		@Column
		private String dept;

 
	}