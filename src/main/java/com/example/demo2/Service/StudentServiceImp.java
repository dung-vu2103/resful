package com.example.demo2.Service;

import com.example.demo2.model.Student;
import com.example.demo2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student addStudent(Student student) {
        // Thực hiện validate thông tin student ở đây
        return studentRepository.save(student);
    }
    @Override
    public Student updateStudent(Long id, Student student) {
        // Thực hiện validate thông tin student ở đây
        student.setId(id);
        return studentRepository.save(student);
    }
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    @Override
    public List<Student> searchStudents(String fullName, LocalDate startDate, LocalDate endDate,
                                        String gender, String hometown, String className,
                                        String major, Double minAverageMark, Double maxAverageMark) {
        // Gọi các phương thức tìm kiếm từ repository và trả về kết quả
        if (fullName != null) {
            return studentRepository.findByFullNameContainingIgnoreCase(fullName);
        } else if (startDate != null && endDate != null) {
            return studentRepository.findByBirthdayBetween(startDate, endDate);
        } else if (gender != null) {
            return studentRepository.findByGender(gender);
        } else if (hometown != null) {
            return studentRepository.findByHometown(hometown);
        } else if (className != null) {
            return studentRepository.findByClassName(className);
        } else if (major != null) {
            return studentRepository.findByMajor(major);
        } else if (minAverageMark != null && maxAverageMark != null) {
            return studentRepository.findByAverageMarkBetween(minAverageMark, maxAverageMark);
        } else {
            return List.of();
        }
    }
    @Override
    public List<Student> getBirthdayStudents() {
        LocalDate today = LocalDate.now();
        return studentRepository.findByBirthday(today);
    }
}
