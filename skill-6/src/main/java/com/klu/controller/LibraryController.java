package com.klu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;

@RestController
public class LibraryController {

List<Book> bookList = new ArrayList<>();

// 1 welcome
@GetMapping("/welcome")
public String welcome() {
return "Welcome to Online Library";
}

// 2 count
@GetMapping("/count")
public int count() {
return 100;
}

// 3 price
@GetMapping("/price")
public double price() {
return 499.99;
}

// 4 books list
@GetMapping("/books")
public List<String> books() {

List<String> titles = new ArrayList<>();
titles.add("Java Programming");
titles.add("Spring Boot Guide");
titles.add("Data Structures");

return titles;
}

// 5 books by id
@GetMapping("/books/{id}")
public String getBook(@PathVariable int id) {

return "Book details for ID: " + id;
}

// 6 search by request param
@GetMapping("/search")
public String search(@RequestParam String title) {

return "Searching for book: " + title;
}

// 7 author name
@GetMapping("/author/{name}")
public String author(@PathVariable String name) {

return "Books written by Author: " + name;
}

// 8 add book
@PostMapping("/addbook")
public String addBook(@RequestBody Book book) {

bookList.add(book);
return "Book Added Successfully";
}

// 9 view books
@GetMapping("/viewbooks")
public List<Book> viewBooks() {

return bookList;
}

}