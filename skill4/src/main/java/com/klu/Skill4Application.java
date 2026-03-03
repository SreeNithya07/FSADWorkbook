package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klu.model.Student;

@SpringBootApplication
public class Skill4Application implements CommandLineRunner {

    @Autowired
    private Student student;

    public static void main(String[] args) {
        SpringApplication.run(Skill4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        student.display();  
    }
}