package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public Student addStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        Student s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            s.setCourse(student.getCourse());
            return repo.save(s);
        }
        return null;
    }

    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}