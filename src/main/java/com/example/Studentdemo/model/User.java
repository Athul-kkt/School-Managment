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
@Table(name="user_table")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Column
    private String userName;
 
    @Column
    private String userRole; // student, teacher, 
    
    @Column
    private String email;

    @Column
    private String password;
 
 
}
