package com.example.demo.Student;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long ID;
    private  String name;
    // transient means do need it a column
    @Transient
    private  Integer age;
    private LocalDate DOB;
    private String email;

    public Student() {}

    public Student(long ID, String name, /* Integer age,*/ LocalDate DOB, String email) {
        this.ID = ID;
        this.name = name;
   //     this.age = age;
        this.DOB = DOB;
        this.email = email;
    }

    public Student(String name, Integer age, LocalDate DOB, String email) {
        this.name = name;
    //    this.age = age;
        this.DOB = DOB;
        this.email = email;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return Period.between(DOB, LocalDate.now()).getYears();
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", DOB=" + DOB +
                ", email='" + email + '\'' +
                '}';
    }
}
