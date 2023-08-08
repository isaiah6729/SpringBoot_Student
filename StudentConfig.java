package com.example.demo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(student_repository student_repository) {
        return args -> {
            Student isaiah =  new Student("isaiah", 37, LocalDate.of(1985,12,16), "isaiah.lco@gmail.com" );
            Student myron =   new Student("alex", 73, LocalDate.of(1985,12,16), "me.lco@gmail.com" );
            Student steve =   new Student("steve", 73, LocalDate.of(1985,12,16), "steve.lco@gmail.com" );


            student_repository.saveAll(List.of(isaiah,myron,steve));
        };
    }

}
