package com.example.demo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// responsible for data acccess will use this inside of service
@Repository
public interface student_repository extends JpaRepository<Student, Long> {

    // select * from student where email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentbyEmail(String email);



}
