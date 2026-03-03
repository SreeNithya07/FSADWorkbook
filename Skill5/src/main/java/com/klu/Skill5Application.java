package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klu.model.Student;

@SpringBootApplication
public class Skill5Application implements CommandLineRunner {

    @Autowired
    private Student student;

    public static void main(String[] args) {
        SpringApplication.run(Skill5Application.class, args);
    }

    @Override
    public void run(String... args) {
        student.display();
    }
}