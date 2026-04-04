package com.klu.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.klu.backend.model.User;
import com.klu.backend.repository.UserRepository;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository repo;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        Optional<User> found = repo.findByUsername(user.getUsername());

        if (found.isPresent() &&
            found.get().getPassword().equals(user.getPassword())) {
            return found.get();
        }

        throw new RuntimeException("Invalid credentials");
    }

    // GET PROFILE
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }
}