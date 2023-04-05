package com.example.SpringBackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname",nullable = false)
    private String lastName;
    @Column(name = "lastname",nullable = false)
    private String firstName;
    @Column(name = "email",nullable = false)
    private String email;


}
