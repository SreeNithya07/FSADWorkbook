package com.klu.controller;

import com.klu.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System";
    }

    // book count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // sample price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // list of titles
    @GetMapping("/books")
    public List<String> books() {

        List<String> titles = new ArrayList<>();
        titles.add("Java Programming");
        titles.add("Spring Boot Guide");
        titles.add("Data Structures");

        return titles;
    }

    // book by id
    @GetMapping("/books/{id}")
    public String bookById(@PathVariable int id) {
        return "Book Details for ID: " + id;
    }

    // search book
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching book with title: " + title;
    }

    // author
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // add book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // view books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}