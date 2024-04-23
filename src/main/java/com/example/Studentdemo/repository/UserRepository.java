package com.example.Studentdemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Studentdemo.model.User;
 

 
public interface UserRepository extends JpaRepository<User,Long> {
//	List<User> findByUserType(String userType);
	List<User> findByUserRole(String UserRole);
//	Optional<User>findByEmail(String email);
	User findByEmail(String email);
}