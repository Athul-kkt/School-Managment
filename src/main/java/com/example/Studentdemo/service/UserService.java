package com.example.Studentdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.Studentdemo.model.User;
import com.example.Studentdemo.model.Login.UserLoginResponse;
import com.example.Studentdemo.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public ResponseEntity<List<User>> getAllUsers(){
		try {
            List<User> userList = new ArrayList<>();
            userRepository.findAll().forEach(userList::add);
 
            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
 
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }	
	}
	
	public void addingUser(String userName,String email, String password, String userRole) {
        
		User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserRole(userRole);
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("User with email '" + email + "' already exists.");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while adding user.");
        }
        
        
    }
	public ResponseEntity<User> addUser(User user) {

        try {
            User userObj = userRepository.save(user);
            return new ResponseEntity<>(userObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	public UserLoginResponse authenticate(String email, String password) {
        // Fetch user from database by email
        User user = userRepository.findByEmail(email);

        // Check if user exists and password matches
        if (user != null && user.getPassword().equals(password)) {
            return new UserLoginResponse(true, user.getUserRole());
        } else {
            return new UserLoginResponse(false, null);
        }
    }
    public ResponseEntity<List<User>> getUserByRole(String userRole) {
    	try {
            List<User> userList = new ArrayList<>();
            userRepository.findByUserRole(userRole).forEach(userList::add);
 
            if (userList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
 
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch(Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }	
    }
 
}
//@Service
//public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//    public User addUser(User user) {
//        // You can add validation logic here
//        return userRepository.save(user);
//    }
//

//}