package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.Student;

public class MainApp {

    public static void main(String[] args) {

        // Annotation Configuration
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student s1 = context.getBean(Student.class);
        s1.display();

        System.out.println("-----------------------");

        // XML Configuration
        ApplicationContext context1 =
                new ClassPathXmlApplicationContext("student.xml");

        Student s2 = (Student) context1.getBean("student");
        s2.display();
    }
}