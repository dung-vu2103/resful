package com.example.demo2.Service;

import com.example.demo2.model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudent(Long id);

    List<Student> searchStudents(String fullName, LocalDate startDate, LocalDate endDate,
                                 String gender, String hometown, String className,
                                 String major, Double minAverageMark, Double maxAverageMark);

    List<Student> getBirthdayStudents();
}
