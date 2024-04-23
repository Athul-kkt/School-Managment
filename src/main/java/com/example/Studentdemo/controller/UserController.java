package com.example.Studentdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Studentdemo.model.User;
import com.example.Studentdemo.model.Login.LoginRequest;
import com.example.Studentdemo.model.Login.LoginResponse;
import com.example.Studentdemo.model.Login.UserLoginResponse;
import com.example.Studentdemo.repository.UserRepository;
import com.example.Studentdemo.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@CrossOrigin("*")
@RestController
@RequestMapping("/userapi")
public class UserController {
 
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
 
   
    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
       return userService.addUser(user);
    }
    
    @GetMapping("/getAllusers")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/getAdminUsers")
    public ResponseEntity<List<User>> getAdminUsers() {
        return userService.getUserByRole("Admin");
    }
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        UserLoginResponse response = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (response.isAuthenticated()) {
            return new LoginResponse("Login successful!", response.getUserRole());
        } else {
            return new LoginResponse("Invalid email or password", null);
        }
    }
}
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//    @PostMapping("/add")
//    public User addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }
//
//    @GetMapping("/getById/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }
//}