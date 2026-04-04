package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Student;
import com.klu.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Operation(summary = "Add a new student")
    @ApiResponse(responseCode = "200", description = "Student added successfully")
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.addStudent(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @Operation(summary = "Get student by ID")
    @ApiResponse(responseCode = "404", description = "Student not found")
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted successfully";
    }
}