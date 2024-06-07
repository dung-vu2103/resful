package com.example.demo2.repository;

import com.example.demo2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFullNameContainingIgnoreCase(String fullName);

    List<Student> findByBirthdayBetween(LocalDate startDate, LocalDate endDate);

    List<Student> findByGender(String gender);

    List<Student> findByHometown(String hometown);

    List<Student> findByClassName(String className);

    List<Student> findByMajor(String major);

    List<Student> findByAverageMarkBetween(Double minAverageMark, Double maxAverageMark);

    List<Student> findByBirthday(LocalDate today);
}
