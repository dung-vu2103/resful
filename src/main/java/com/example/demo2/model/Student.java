package com.example.demo2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "class_name", length = 50, nullable = false)
    private String className;

    @Column(name = "major", length = 50, nullable = false)
    private String major;

    @Column(name = "hometown", length = 50, nullable = false)
    private String hometown;

    @Column(name = "gender", length = 10, nullable = false)
    private String gender;

    @Column(name = "average_mark", nullable = false)
    private Double averageMark;


}
