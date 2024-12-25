package controller;

//src/main/java/com/bookstore/controller/BookController.java
//package com.bookstore.controller;

import dto.BookDTO;
import service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
 private final BookService bookService;
 
 public BookController(BookService bookService) {
     this.bookService = bookService;
 }
 
 @PostMapping
 public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
     return new ResponseEntity<>(bookService.createBook(bookDTO), HttpStatus.CREATED);
 }
 
 @GetMapping
 public ResponseEntity<List<BookDTO>> getAllBooks() {
     return ResponseEntity.ok(bookService.getAllBooks());
 }
 
 @GetMapping("/{id}")
 public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
     return ResponseEntity.ok(bookService.getBookById(id));
 }
 
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
     bookService.deleteBook(id);
     return ResponseEntity.noContent().build();
 }
}
