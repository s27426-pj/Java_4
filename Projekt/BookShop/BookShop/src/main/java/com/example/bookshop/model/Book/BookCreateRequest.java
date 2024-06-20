package com.example.bookshop.model.Book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateRequest {

    private String name;
    private String genre;
    private double price;
    private int pages;
    private int available;

}