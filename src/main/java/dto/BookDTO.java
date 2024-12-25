package dto;

//src/main/java/com/bookstore/dto/BookDTO.java
//package com.bookstore.dto;

import lombok.Data;

@Data
public class BookDTO {
 private Long id;
 private String title;
 private String author;
 private Double price;
 private String isbn;
}
