package service;

//src/main/java/com/bookstore/service/BookService.java
//package com.bookstore.service;

import dto.BookDTO;
import model.Book;
import repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 
 public BookDTO createBook(BookDTO bookDTO) {
     Book book = new Book();
     BeanUtils.copyProperties(bookDTO, book);
     Book savedBook = bookRepository.save(book);
     BeanUtils.copyProperties(savedBook, bookDTO);
     return bookDTO;
 }
 
 public List<BookDTO> getAllBooks() {
     return bookRepository.findAll().stream()
         .map(book -> {
             BookDTO dto = new BookDTO();
             BeanUtils.copyProperties(book, dto);
             return dto;
         })
         .collect(Collectors.toList());
 }
 
 public BookDTO getBookById(Long id) {
     Book book = bookRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Book not found"));
     BookDTO dto = new BookDTO();
     BeanUtils.copyProperties(book, dto);
     return dto;
 }
 
 public void deleteBook(Long id) {
     bookRepository.deleteById(id);
 }
}
