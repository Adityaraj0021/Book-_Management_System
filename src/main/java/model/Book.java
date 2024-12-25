package model;

//src/main/java/com/bookstore/model/Book.java
//package com.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Book {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @NotBlank(message = "Title is required")
 private String title;
 
 @NotBlank(message = "Author is required")
 private String author;
 
 @NotNull(message = "Price is required")
 private Double price;
 
 private String isbn;
}
