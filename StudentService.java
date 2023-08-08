package com.example.demo.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final student_repository student_repository;

    @Autowired
    public StudentService(student_repository student_repository) {
        this.student_repository = student_repository;
    }


    public List<Student> getStudents() {
        return student_repository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = student_repository.findStudentbyEmail(student.getEmail());

        if (studentByEmail.isPresent()) {
            throw new IllegalArgumentException("email taken");
        }
        else {
            student_repository.save(student);
        }
        System.out.println(student);

    }

    public void deleteStudent(Long id) {
        if (student_repository.existsById(id)) {
            student_repository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("student id " + id + " doesnt exists!!!!");
        }
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
              Student student = student_repository.findById(id).orElseThrow(() -> new IllegalArgumentException("dont"));

                if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
                    student.setName(name);
                }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentByEmail = student_repository.findStudentbyEmail(student.getEmail());

            if (studentByEmail.isPresent()) {
                throw new IllegalArgumentException("email taken");
            }
            else {
               student.setEmail(email);
            }
        }
    }
}
