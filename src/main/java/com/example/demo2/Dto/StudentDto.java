package com.example.demo2.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentDto {
    private Integer id;

    private String fullName;

    private Float brithday;

    private String className;

    private String major;

    private String hometown;

    private String gender;

    private Float average_mark;
}
