package com.example.bookshop.model.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Author {

    @Id
    private Long id;
    String name;
    String surname;

}