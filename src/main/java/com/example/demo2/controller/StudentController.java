package com.example.demo2.controller;

import com.example.demo2.Service.StudentService;
import com.example.demo2.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
   @Autowired
    StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student createdStudent = studentService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam(required = false) String fullName,
                                                        @RequestParam(required = false) LocalDate startDate,
                                                        @RequestParam(required = false) LocalDate endDate,
                                                        @RequestParam(required = false) String gender,
                                                        @RequestParam(required = false) String hometown,
                                                        @RequestParam(required = false) String className,
                                                        @RequestParam(required = false) String major,
                                                        @RequestParam(required = false) Double minAverageMark,
                                                        @RequestParam(required = false) Double maxAverageMark) {
        List<Student> students = studentService.searchStudents(fullName, startDate, endDate,
                gender, hometown, className, major, minAverageMark, maxAverageMark);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/birthday")
    public ResponseEntity<List<Student>> getBirthdayStudents() {
        List<Student> students = studentService.getBirthdayStudents();
        return ResponseEntity.ok(students);
    }
}
