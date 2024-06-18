package com.example.bookshop.feign.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BooksToOrder {
    private UUID id;
    private String name;
    private int views;
}
