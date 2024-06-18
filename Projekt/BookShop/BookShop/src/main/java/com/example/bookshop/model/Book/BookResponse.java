package com.example.bookshop.model.Book;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class BookResponse {

        private String name;
        private String genre;
        private double price;
        private int pages;
        private int views;
        private int available;
        private String author;


}
